package com.sun5066.presentation.main.mvi

import androidx.compose.runtime.Stable
import com.sun5066.base.mvi.BaseState
import com.sun5066.presentation.main.model.MatchInfo

@Stable
data class MainState(
    val matches: List<MatchInfo>,
    val showLoadingProgress: Boolean,
    val isLoadingNextPage: Boolean,
) : BaseState {
    companion object {
        fun init(
            matches: List<MatchInfo> = emptyList(),
            showLoadingProgress: Boolean = false,
            isLoadingNextPage: Boolean = false,
        ): MainState {
            return MainState(
                matches = matches,
                showLoadingProgress = showLoadingProgress,
                isLoadingNextPage = isLoadingNextPage,
            )
        }
    }
}