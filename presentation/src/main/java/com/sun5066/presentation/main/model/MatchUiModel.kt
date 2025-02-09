package com.sun5066.presentation.main.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class MatchUiModel(
    val metadata: MetadataUiModel,
    val info: InfoUiModel
) : Parcelable