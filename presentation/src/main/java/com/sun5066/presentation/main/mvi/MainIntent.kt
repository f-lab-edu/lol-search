package com.sun5066.presentation.main.mvi

import com.sun5066.base.mvi.BaseIntent

sealed interface MainIntent : BaseIntent {
    data class Search(val searchText: String) : MainIntent
}