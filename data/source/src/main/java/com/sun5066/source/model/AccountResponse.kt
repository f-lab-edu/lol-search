package com.sun5066.source.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountResponse(
    @SerialName("puuid") val puuId: String,
    @SerialName("gameName") val gameName: String,
    @SerialName("tagLine") val tagLine: String,
)