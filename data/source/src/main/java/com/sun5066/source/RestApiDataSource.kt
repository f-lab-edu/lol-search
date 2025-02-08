package com.sun5066.source

import com.sun5066.source.model.AccountResponse
import com.sun5066.source.model.SummonerResponse

interface RestApiDataSource {
    suspend fun getAccount(gameName: String, tagLine: String): AccountResponse
    suspend fun getSummoner(puuId: String): SummonerResponse
}