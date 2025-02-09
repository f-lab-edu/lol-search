package com.sun5066.rest_api.source

import com.sun5066.rest_api.RiotAsiaApi
import com.sun5066.rest_api.RiotKoreaApi
import com.sun5066.source.RestApiDataSource
import com.sun5066.source.model.AccountResponse
import com.sun5066.source.model.MatchResponse
import com.sun5066.source.model.SummonerResponse
import javax.inject.Inject

class RestApiDataSourceImpl @Inject constructor(
    private val riotAsiaApi: RiotAsiaApi,
    private val riotKoreaApi: RiotKoreaApi,
) : RestApiDataSource {

    override suspend fun getAccount(gameName: String, tagLine: String): AccountResponse =
        riotAsiaApi.getAccount(gameName, tagLine)

    override suspend fun getSummoner(puuId: String): SummonerResponse =
        riotKoreaApi.getSummoner(puuId)

    override suspend fun getMatchIds(
        puuId: String,
        start: Int,
        count: Int,
        startTime: Long?,
        endTime: Long?,
        queue: Int?,
        type: String?
    ): List<String> = riotAsiaApi.getMatchIds(puuId, start, count, startTime, endTime, queue, type)

    override suspend fun getMatch(matchId: String): MatchResponse =
        riotAsiaApi.getMatch(matchId)

}