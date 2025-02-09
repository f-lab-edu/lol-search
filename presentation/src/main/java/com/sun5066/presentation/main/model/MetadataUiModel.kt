package com.sun5066.presentation.main.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class MetadataUiModel(
    val dataVersion: String,
    val matchId: String,
    val participants: List<String>
) : Parcelable
