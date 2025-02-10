package com.sun5066.presentation.main.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class Participant(
    val summonerName: String,
    val individualPosition: String,
    val totalDamageDealtToChampions: Int,
    val win: Boolean,
    val kills: Int,
    val assists: Int,
    val deaths: Int,
    val champExperience: Int,
    val champLevel: Int,
    val championId: Int,
    val championName: String,
    val championTransform: Int,
) : Parcelable