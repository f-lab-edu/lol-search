package com.sun5066.presentation.main.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class ObjectiveUiModel(
    val first: Boolean,
    val kills: Int
) : Parcelable