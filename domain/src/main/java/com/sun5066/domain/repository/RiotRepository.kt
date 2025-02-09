package com.sun5066.domain.repository

import com.sun5066.domain.model.MatchDto
import com.sun5066.domain.model.SummonerDto

interface RiotRepository {
    suspend fun getSummoner(gameName: String, tagLine: String): SummonerDto
    suspend fun getMatches(
        puuId: String,
        start: Int,
        count: Int,
        startTime: Long?,
        endTime: Long?,
        queue: Int?,
        type: String?
    ): List<MatchDto>
}