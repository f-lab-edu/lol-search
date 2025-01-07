package com.sun5066.presentation.main

import androidx.lifecycle.SavedStateHandle
import com.sun5066.base.mvi.CommonViewModel
import com.sun5066.domain.usecase.GetAccountUseCase
import com.sun5066.presentation.main.ui.model.mapper.AccountDtoToVoMapper
import com.sun5066.presentation.main.ui.mvi.MainIntent
import com.sun5066.presentation.main.ui.mvi.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAccountUseCase: GetAccountUseCase,
    private val accountDtoToVoMapper: AccountDtoToVoMapper,
    savedStateHandle: SavedStateHandle
) : CommonViewModel<MainIntent, MainState>(MainState.Init, savedStateHandle) {

    override fun processIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.Search -> search(intent)
        }
    }

    private fun search(intent: MainIntent.Search) {
        safeLaunch(
            showLoadingIndicator = true,
        ) {
            val account = getAccountUseCase
                .invoke(intent.tagLine, intent.tagLine)
                .let(accountDtoToVoMapper::toModel)

            updateState { copy(account = account) }
        }
    }

}