package com.sun5066.rest_api.interceptor

import com.sun5066.common.exception.HttpResponseException
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ResponseErrorHandleInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val response = proceed(request())

        if (!response.isSuccessful) {
            throw HttpResponseException(response.code, response.message)
        }

        response
    }
}