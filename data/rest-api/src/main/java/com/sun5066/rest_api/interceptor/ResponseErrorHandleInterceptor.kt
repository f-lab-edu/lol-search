package com.sun5066.rest_api.interceptor

import com.sun5066.config.exception.ApiException
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ResponseErrorHandleInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val response = proceed(request())

        if (!response.isSuccessful) {
            throw ApiException(response.code, response.message)
        }

        response
    }
}