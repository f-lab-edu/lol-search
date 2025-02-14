package com.sun5066.rest_api.interceptor

import com.sun5066.rest_api.util.Cacheable
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation
import javax.inject.Inject

class CacheInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        var request = request()

        request.tag(Invocation::class.java)
            ?.method()
            ?.getAnnotation(Cacheable::class.java)
            ?.let { cacheable ->
                val cacheControl = CacheControl.Builder()
                    .maxStale(cacheable.value, cacheable.timeUnit)
                    .build()

                request = request().newBuilder()
                    .cacheControl(cacheControl)
                    .build()
            }

        chain.proceed(request)
    }
}