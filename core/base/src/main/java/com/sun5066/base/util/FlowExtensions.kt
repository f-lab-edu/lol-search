package com.sun5066.base.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.sun5066.base.mvi.SideEffect
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

@Composable
inline fun <T : SideEffect> Flow<T>.CollectSideEffect(
    crossinline block: suspend CoroutineScope.(T) -> Unit,
) {
    LaunchedEffect(this) {
        collect { block(it) }
    }
}