package com.sun5066.base.mvi

import android.os.Parcelable
import androidx.annotation.StringRes
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.sun5066.base.R
import com.sun5066.config.Constants
import com.sun5066.config.exception.ApiException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

sealed interface CommonSideEffect : SideEffect {
    data class LoadingIndicator(val show: Boolean) : CommonSideEffect
    data class ShowSnackBarRes(@StringRes val res: Int) : CommonSideEffect
}

abstract class CommonViewModel<INTENT : Any, STATE : Parcelable>(
    initialState: STATE,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<INTENT, STATE, CommonSideEffect>(initialState, savedStateHandle) {

    private fun apiExceptionHandle(responseCode: Int) {
        when (responseCode) {
            Constants.RESPONSE_CODE_BAD_REQUEST -> R.string.common_msg_error_bad_request
            Constants.RESPONSE_CODE_UNAUTHORIZED -> R.string.common_msg_error_unauthorized
            Constants.RESPONSE_CODE_FORBIDDEN -> R.string.common_msg_error_forbidden
            Constants.RESPONSE_CODE_NOT_FOUND -> R.string.common_msg_error_not_found
            Constants.RESPONSE_CODE_UNSUPPORTED_MEDIA_TYPE -> R.string.common_msg_error_unsupported_media_type
            Constants.RESPONSE_CODE_RATE_LIMIT_EXCEEDED -> R.string.common_msg_error_rate_limit_exceeded
            Constants.RESPONSE_CODE_INTERNAL_SERVER_ERROR -> R.string.common_msg_error_internal_server_error
            Constants.RESPONSE_CODE_SERVICE_UNAVAILABLE -> R.string.common_msg_error_service_unavailable
            else -> R.string.common_msg_error_network
        }.also { postSideEffect(CommonSideEffect.ShowSnackBarRes(it)) }
    }

    override fun commonErrorHandle(error: Throwable?) {
        when (error) {
            is ApiException -> apiExceptionHandle(error.responseCode)
            else -> postSideEffect(CommonSideEffect.ShowSnackBarRes(R.string.common_msg_error_network))
        }
    }

    final override fun safeLaunch(
        coroutineContext: CoroutineContext,
        showLoadingIndicator: Boolean,
        error: ((Throwable) -> Unit)?,
        completed: (() -> Unit)?,
        block: suspend CoroutineScope.() -> Unit
    ): Job = viewModelScope.launch(coroutineContext) {
        runCatching {
            if (showLoadingIndicator) {
                postSideEffect(CommonSideEffect.LoadingIndicator(true))
            }
            block()
        }.onFailure { throwable ->
            error?.invoke(throwable) ?: commonErrorHandle(throwable)
        }
    }.apply {
        invokeOnCompletion {
            if (showLoadingIndicator) {
                postSideEffect(CommonSideEffect.LoadingIndicator(false))
            }
            completed?.invoke()
        }
    }

}