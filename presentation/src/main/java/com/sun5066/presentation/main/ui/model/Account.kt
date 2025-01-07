package com.sun5066.presentation.main.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Account(
    val puuId: String,
    val gameName: String,
    val tagLine: String,
) : Parcelable