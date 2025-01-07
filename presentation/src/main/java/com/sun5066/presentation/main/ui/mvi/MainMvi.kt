package com.sun5066.presentation.main.ui.mvi

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.sun5066.presentation.main.ui.model.Account
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class MainState(
    val account: Account?
) : Parcelable {
    companion object {
        val Init: MainState = MainState(account = null)
    }
}

@Immutable
sealed interface MainIntent {
    data class Search(val gameName: String, val tagLine: String) : MainIntent
}