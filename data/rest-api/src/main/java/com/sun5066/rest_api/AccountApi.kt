package com.sun5066.rest_api

import com.sun5066.source.model.AccountResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AccountApi {

    @GET("v1/accounts/by-riot-id/{gameName}/{tagLine}")
    suspend fun getAccount(
        @Path("gameName") gameName: String,
        @Path("tagLine") tagLine: String
    ): AccountResponse

}