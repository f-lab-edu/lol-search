package com.sun5066.presentation.main.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class SummonerUiModel(
    val id: String,
    val puuId: String,
    val accountId: String,
    val profileIconId: Int,
    val revisionDate: Long,
    val summonerLevel: Int,
    val gameName: String,
    val tagLine: String
) : Parcelable