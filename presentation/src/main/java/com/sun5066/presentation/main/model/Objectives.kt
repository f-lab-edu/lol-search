package com.sun5066.presentation.main.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class Objectives(
    val atakhan: Objective,
    val baron: Objective,
    val champion: Objective,
    val dragon: Objective,
    val horde: Objective,
    val inhibitor: Objective,
    val riftHerald: Objective,
    val tower: Objective
) : Parcelable