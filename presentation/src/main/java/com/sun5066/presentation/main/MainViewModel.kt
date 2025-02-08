package com.sun5066.presentation.main

import com.sun5066.base.BaseViewModel
import com.sun5066.base.CommonEffect
import com.sun5066.domain.usecase.GetSummonerUseCase
import com.sun5066.presentation.R
import com.sun5066.presentation.main.model.mapper.SummonerDtoToVoMapper
import com.sun5066.presentation.main.mvi.MainEffect
import com.sun5066.presentation.main.mvi.MainIntent
import com.sun5066.presentation.main.mvi.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSummonerUseCase: GetSummonerUseCase,
    private val summonerDtoToVoMapper: SummonerDtoToVoMapper
) : BaseViewModel<MainIntent, MainState, MainEffect>(MainState.init()) {

    override fun processIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.Search -> search(intent)
        }
    }

    private fun search(intent: MainIntent.Search) {
        runCatching {
            // '#' 문자를 기준으로 최대 2개로 분리하여 게임 이름과 태그라인을 구분
            val parts = intent.searchText.split("#", limit = 2)

            if (parts.size < 2) {
                postSideEffect(CommonEffect.ShowSnackBarRes(R.string.snack_bar_message_invalid_search_text_format_tagline))
                return
            }

            // 각 부분의 앞뒤 공백 제거
            val gameName = parts[0].trim()
            val tagLine = parts[1].trim()

            if (tagLine.isBlank()) {
                postSideEffect(CommonEffect.ShowSnackBarRes(R.string.snack_bar_message_empty_or_blank_tagline))
                return
            }

            gameName to tagLine
        }
            .onFailure { postSideEffect(CommonEffect.ShowSnackBarRes(R.string.snack_bar_message_invalid_search_text_format)) }
            .onSuccess { (gameName, tagLine) ->
                updateState { copy(showLoadingProgress = true) }

                safeLaunch(
                    onComplete = { updateState { copy(showLoadingProgress = false) } }
                ) {
                    val account = getSummonerUseCase(gameName, tagLine).let(summonerDtoToVoMapper::toModel)

                    updateState { copy(summoner = account) }
                }
            }
    }

}