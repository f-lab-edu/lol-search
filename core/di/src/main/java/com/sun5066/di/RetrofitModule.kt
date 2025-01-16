package com.sun5066.di

import com.sun5066.config.Constants
import com.sun5066.di.retrofits.AsiaRetrofit
import com.sun5066.di.retrofits.KoreaRetrofit
import com.sun5066.rest_api.AccountApi
import com.sun5066.rest_api.interceptor.AuthenticationInterceptor
import com.sun5066.rest_api.interceptor.ResponseErrorHandleInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Named(Constants.INJECT_NAMED_RIOT_TOKEN)
    fun provideToken(): String = BuildConfig.TOKEN

    @Provides
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        authenticationInterceptor: AuthenticationInterceptor,
        responseErrorHandleInterceptor: ResponseErrorHandleInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
        .writeTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(authenticationInterceptor)
        .addInterceptor(responseErrorHandleInterceptor)
        .build()

    @Provides
    @Singleton
    @Named(Constants.INJECT_NAMED_KOTLINX_SERIALIZATION)
    fun provideKotlinxSerializationJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @AsiaRetrofit
    @Singleton
    fun provideAsiaRetrofit(
        httpClient: OkHttpClient,
        @Named(Constants.INJECT_NAMED_KOTLINX_SERIALIZATION) json: Json,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.ASIA_ACCOUNT_URL)
        .client(httpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    @Provides
    @KoreaRetrofit
    @Singleton
    fun provideKoreaRetrofit(
        httpClient: OkHttpClient,
        @Named(Constants.INJECT_NAMED_KOTLINX_SERIALIZATION) json: Json,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.KR_BASE_URL)
        .client(httpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    @Provides
    @Singleton
    fun provideAccountApi(
        @AsiaRetrofit retrofit: Retrofit
    ): AccountApi = retrofit.create(AccountApi::class.java)

}