package com.sun5066.rest_api.interceptor

import com.sun5066.config.Constants
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Named

class AuthenticationInterceptor @Inject constructor(
    @Named(Constants.INJECT_NAMED_RIOT_TOKEN) private val token: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("X-Riot-Token", token)
                .build()
        )
    }
}