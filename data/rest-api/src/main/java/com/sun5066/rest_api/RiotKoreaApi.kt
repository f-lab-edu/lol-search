package com.sun5066.rest_api

import com.sun5066.source.model.SummonerResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RiotKoreaApi {

    @GET("summoner/v4/summoners/by-puuid/{puuid}")
    suspend fun getSummoner(@Path("puuid") puuId: String): SummonerResponse

}