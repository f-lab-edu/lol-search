package com.sun5066.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sun5066.base.mvi.BaseEffect
import com.sun5066.base.mvi.BaseIntent
import com.sun5066.base.mvi.BaseState
import com.sun5066.common.constatns.HttpResponseCode
import com.sun5066.common.constatns.HttpResponseConstants
import com.sun5066.common.exception.HttpResponseException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.cancellation.CancellationException

abstract class BaseViewModel<INTENT : BaseIntent, STATE : BaseState, SIDE_EFFECT : BaseEffect>(
    initialState: STATE
) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    protected val currentState: STATE get() = state.value

    private val _effect = Channel<SIDE_EFFECT>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    private val _commonEffect = Channel<CommonEffect>(Channel.BUFFERED)
    val commonEffect = _commonEffect.receiveAsFlow()

    private val defaultCEH by lazy(LazyThreadSafetyMode.PUBLICATION) {
        CoroutineExceptionHandler { _, throwable ->
            runCatching { commonErrorHandle(throwable) }
                .onFailure { error ->
                    error.printStackTrace()
                }
        }
    }

    private fun commonHttpResponseExceptionHandle(@HttpResponseCode responseCode: Int) {
        when (responseCode) {
            HttpResponseConstants.RESPONSE_CODE_400_BAD_REQUEST -> R.string.error_http_status_400
            HttpResponseConstants.RESPONSE_CODE_401_UNAUTHORIZED -> R.string.error_http_status_401
            HttpResponseConstants.RESPONSE_CODE_403_FORBIDDEN -> R.string.error_http_status_403
            HttpResponseConstants.RESPONSE_CODE_404_NOT_FOUND -> R.string.error_http_status_404
            HttpResponseConstants.RESPONSE_CODE_429_RATE_LIMIT_EXCEEDED -> R.string.error_http_status_429
            HttpResponseConstants.RESPONSE_CODE_500_INTERNAL_SERVER_ERROR -> R.string.error_http_status_500
            HttpResponseConstants.RESPONSE_CODE_503_SERVICE_UNAVAILABLE -> R.string.error_http_status_503
            else -> R.string.error_service_connection
        }.also { postSideEffect(CommonEffect.ShowSnackBarRes(it)) }
    }

    abstract fun processIntent(intent: INTENT)

    protected open fun commonErrorHandle(error: Throwable?) {
        when (error) {
            is HttpResponseException -> commonHttpResponseExceptionHandle(error.responseCode)
            is IOException -> postSideEffect(CommonEffect.ShowSnackBarRes(R.string.error_service_connection))
            else -> {
                if (BuildConfig.DEBUG) {
                    error?.printStackTrace()
                }
            }
        }
    }

    protected fun updateState(reducer: STATE.() -> STATE) {
        _state.update(reducer)
    }

    protected fun postSideEffect(sideEffect: SIDE_EFFECT) {
        viewModelScope.launch {
            _effect.send(sideEffect)
        }
    }

    protected fun postSideEffect(sideEffect: CommonEffect) {
        viewModelScope.launch {
            _commonEffect.send(sideEffect)
        }
    }

    protected fun safeLaunch(
        scope: CoroutineScope = viewModelScope,
        coroutineContext: CoroutineContext = defaultCEH,
        onError: ((Throwable) -> Boolean)? = null,
        onActionCancel: (() -> Unit)? = null,
        onActionComplete: (() -> Unit)? = null,
        onJobComplete: (() -> Unit)? = null,
        action: suspend CoroutineScope.() -> Unit
    ): Job = scope.launch(coroutineContext) {
        try {
            action()
        } catch (e: CancellationException) {
            withContext(NonCancellable) {
                onActionCancel?.invoke()
            }
            throw e
        } catch (e: Exception) {
            if (onError == null || !onError.invoke(e)) {
                commonErrorHandle(e)
            }
        } finally {
            withContext(NonCancellable) {
               onActionComplete?.invoke()
            }
        }
    }.apply {
        if (onJobComplete != null) {
            invokeOnCompletion { onJobComplete() }
        }
    }

}