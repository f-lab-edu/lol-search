package com.sun5066.domain.repository

import com.sun5066.domain.model.SummonerDto

interface RiotRepository {
    suspend fun getSummoner(gameName: String, tagLine: String): SummonerDto
}