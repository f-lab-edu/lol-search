package com.sun5066.presentation.main.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class Team(
    val bans: List<Ban>,
    val objectives: Objectives,
    val teamId: Int,
    val win: Boolean
) : Parcelable