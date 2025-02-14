package com.sun5066.rest_api

import com.sun5066.rest_api.util.Cacheable
import com.sun5066.source.model.AccountResponse
import com.sun5066.source.model.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface RiotAsiaApi {

    @GET("riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}")
    @Cacheable(value = 30, timeUnit = TimeUnit.DAYS)
    suspend fun getAccount(
        @Path("gameName") gameName: String,
        @Path("tagLine") tagLine: String
    ): AccountResponse

    @GET("lol/match/v5/matches/by-puuid/{puuid}/ids")
    @Cacheable(value = 2, timeUnit = TimeUnit.MINUTES)
    suspend fun getMatchIds(
        @Path("puuid") puuId: String,
        @Query("start") start: Int,
        @Query("count") count: Int,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("queue") queue: Int?,
        @Query("type") type: String?
    ): List<String>

    @GET("lol/match/v5/matches/{matchId}")
    @Cacheable(value = 2, timeUnit = TimeUnit.MINUTES)
    suspend fun getMatch(@Path("matchId") matchId: String): MatchResponse

}