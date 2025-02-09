package com.sun5066.domain.model

data class SummonerDto(
    val id: String,
    val puuId: String,
    val accountId: String,
    val profileIconId: Int,
    val revisionDate: Long,
    val summonerLevel: Int,
    val gameName: String,
    val tagLine: String
)
