package com.sun5066.base

import androidx.annotation.StringRes
import com.sun5066.base.mvi.BaseEffect

sealed interface CommonEffect : BaseEffect {
    data class ShowSnackBarRes(@StringRes val resourceId: Int) : CommonEffect
}