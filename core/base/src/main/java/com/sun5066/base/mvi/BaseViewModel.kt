package com.sun5066.base.mvi

import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sun5066.config.Constants
import com.sun5066.config.exception.RequireErrorHandleException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.flow.receiveAsFlow
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

interface SideEffect

abstract class BaseViewModel<INTENT : Any, STATE : Parcelable, SIDE_EFFECT : SideEffect>(
    initialState: STATE,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val state = savedStateHandle.getStateFlow(Constants.MVI_VIEW_MODEL_STATE_KEY, initialState)

    private val currentState: STATE get() = state.value

    private val _sideEffect = Channel<SIDE_EFFECT>(Channel.UNLIMITED)
    val sideEffect = _sideEffect.receiveAsFlow()

    abstract fun processIntent(intent: INTENT)

    protected open fun commonErrorHandle(error: Throwable?) {
        throw RequireErrorHandleException(error?.message)
    }

    protected abstract fun safeLaunch(
        coroutineContext: CoroutineContext = EmptyCoroutineContext,
        showLoadingIndicator: Boolean = false,
        error: ((Throwable) -> Unit)? = null,
        completed: (() -> Unit)? = null,
        block: suspend CoroutineScope.() -> Unit,
    ): Job

    protected fun updateState(reducer: STATE.() -> STATE) {
        savedStateHandle[Constants.MVI_VIEW_MODEL_STATE_KEY] = reducer(currentState)
    }

    protected fun postSideEffect(sideEffect: SIDE_EFFECT) {
        _sideEffect.trySend(sideEffect).onFailure(::commonErrorHandle)
    }

}