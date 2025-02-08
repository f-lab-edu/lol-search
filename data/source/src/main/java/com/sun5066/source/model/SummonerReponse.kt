package com.sun5066.source.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SummonerResponse(
    @SerialName("id") val id: String,
    @SerialName("puuid") val puuId: String,
    @SerialName("accountId") val accountId: String,
    @SerialName("profileIconId") val profileIconId: Int,
    @SerialName("revisionDate") val revisionDate: Long,
    @SerialName("summonerLevel") val summonerLevel: Int
)
