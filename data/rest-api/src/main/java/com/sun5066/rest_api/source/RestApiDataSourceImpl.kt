package com.sun5066.rest_api.source

import com.sun5066.rest_api.RiotAsiaApi
import com.sun5066.rest_api.RiotKoreaApi
import com.sun5066.source.RestApiDataSource
import com.sun5066.source.model.AccountResponse
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

}