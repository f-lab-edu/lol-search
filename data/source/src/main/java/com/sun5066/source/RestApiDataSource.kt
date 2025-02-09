package com.sun5066.source

import com.sun5066.source.model.AccountResponse
import com.sun5066.source.model.MatchResponse
import com.sun5066.source.model.SummonerResponse

interface RestApiDataSource {
    suspend fun getAccount(gameName: String, tagLine: String): AccountResponse
    suspend fun getSummoner(puuId: String): SummonerResponse
    suspend fun getMatchIds(
        puuId: String,
        start: Int,
        count: Int,
        startTime: Long? = null,
        endTime: Long? = null,
        queue: Int? = null,
        type: String? = null
    ): List<String>
    suspend fun getMatch(matchId: String): MatchResponse
}