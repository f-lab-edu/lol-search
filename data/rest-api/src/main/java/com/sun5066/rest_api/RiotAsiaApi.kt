package com.sun5066.rest_api

import com.sun5066.rest_api.util.Cacheable
import com.sun5066.source.model.AccountResponse
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface RiotAsiaApi {

    @GET("v1/accounts/by-riot-id/{gameName}/{tagLine}")
    @Cacheable(value = 30, timeUnit = TimeUnit.DAYS)
    suspend fun getAccount(
        @Path("gameName") gameName: String,
        @Path("tagLine") tagLine: String
    ): AccountResponse

}