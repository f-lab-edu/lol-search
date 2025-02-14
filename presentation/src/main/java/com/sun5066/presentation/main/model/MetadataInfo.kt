package com.sun5066.presentation.main.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class MetadataInfo(
    val dataVersion: String,
    val matchId: String,
    val participants: List<String>
) : Parcelable
