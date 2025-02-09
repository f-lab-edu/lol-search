package com.sun5066.presentation.main.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class ObjectivesUiModel(
    val atakhan: ObjectiveUiModel,
    val baron: ObjectiveUiModel,
    val champion: ObjectiveUiModel,
    val dragon: ObjectiveUiModel,
    val horde: ObjectiveUiModel,
    val inhibitor: ObjectiveUiModel,
    val riftHerald: ObjectiveUiModel,
    val tower: ObjectiveUiModel
) : Parcelable