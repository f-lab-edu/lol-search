package com.sun5066.rest_api

import com.sun5066.rest_api.util.Cacheable
import com.sun5066.source.model.SummonerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface RiotKoreaApi {

    @GET("summoner/v4/summoners/by-puuid/{puuid}")
    @Cacheable(value = 30, timeUnit = TimeUnit.DAYS)
    suspend fun getSummoner(@Path("puuid") puuId: String): SummonerResponse

}