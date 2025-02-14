package com.sun5066.presentation.main.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class MatchInfo(
    val metadata: MetadataInfo,
    val info: GameInfo
) : Parcelable