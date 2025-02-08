package com.sun5066.presentation.main.mvi

import android.os.Parcelable
import androidx.compose.runtime.Stable
import com.sun5066.base.mvi.BaseState
import com.sun5066.presentation.main.model.Account
import kotlinx.parcelize.Parcelize

@Stable
@Parcelize
data class MainState(
    val account: Account?,
    val showLoadingProgress: Boolean
) : BaseState, Parcelable {
    companion object {
        fun init(
            account: Account? = null,
            showLoadingProgress: Boolean = false
        ): MainState {
            return MainState(
                account = account,
                showLoadingProgress = showLoadingProgress
            )
        }
    }
}