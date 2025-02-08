package com.sun5066.base.ui.modifier

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.throttleClick(
    throttleMs: Long = 1000L,
    rippleRadius: Dp = 40.dp,
    interactionSource: MutableInteractionSource? = null,
    onClick: () -> Unit
): Modifier = composed {
    var lastClickTime by remember { mutableLongStateOf(0L) }

    clickable(
        role = Role.Button,
        interactionSource = interactionSource ?: remember { MutableInteractionSource() },
        indication = rememberRipple(bounded = false, radius = rippleRadius)
    ) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime > throttleMs) {
            lastClickTime = currentTime
            onClick()
        }
    }
}