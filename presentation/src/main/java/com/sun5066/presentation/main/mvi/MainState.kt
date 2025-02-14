package com.sun5066.presentation.main.mvi

import androidx.compose.runtime.Stable
import com.sun5066.base.mvi.BaseState
import com.sun5066.presentation.main.model.MatchUiModel
import com.sun5066.presentation.main.model.SummonerUiModel

@Stable
data class MainState(
    val summoner: SummonerUiModel?,
    val matches: List<MatchUiModel>,
    val showLoadingProgress: Boolean
) : BaseState {
    companion object {
        fun init(
            summoner: SummonerUiModel? = null,
            matches: List<MatchUiModel> = emptyList(),
            showLoadingProgress: Boolean = false
        ): MainState {
            return MainState(
                summoner = summoner,
                matches = matches,
                showLoadingProgress = showLoadingProgress
            )
        }
    }
}