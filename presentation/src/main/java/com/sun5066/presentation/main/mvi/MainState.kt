package com.sun5066.presentation.main.mvi

import android.os.Parcelable
import androidx.compose.runtime.Stable
import com.sun5066.base.mvi.BaseState
import com.sun5066.presentation.main.model.Summoner
import kotlinx.parcelize.Parcelize

@Stable
@Parcelize
data class MainState(
    val summoner: Summoner?,
    val showLoadingProgress: Boolean
) : BaseState, Parcelable {
    companion object {
        fun init(
            summoner: Summoner? = null,
            showLoadingProgress: Boolean = false
        ): MainState {
            return MainState(
                summoner = summoner,
                showLoadingProgress = showLoadingProgress
            )
        }
    }
}