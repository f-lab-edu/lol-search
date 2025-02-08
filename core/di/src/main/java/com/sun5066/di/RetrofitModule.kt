package com.sun5066.di

import android.content.Context
import android.os.StatFs
import com.sun5066.common.constatns.Constants
import com.sun5066.di.retrofit.RetrofitRiotAsia
import com.sun5066.di.retrofit.RetrofitRiotKorea
import com.sun5066.rest_api.RiotAsiaApi
import com.sun5066.rest_api.RiotKoreaApi
import com.sun5066.rest_api.interceptor.AuthenticationInterceptor
import com.sun5066.rest_api.interceptor.CacheInterceptor
import com.sun5066.rest_api.interceptor.ResponseErrorHandleInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
import kotlin.math.max
import kotlin.math.min

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
    fun providesCache(@ApplicationContext context: Context): Cache {
        val cacheDir = File(context.cacheDir, Constants.OKHTTP_CACHE_DIR_NAME).apply(File::mkdirs)
        val statFs = StatFs(cacheDir.absolutePath)
        val availableBytes = statFs.availableBytes
        val calculatedSize = (availableBytes * 0.25).toLong()
        val cacheSize = min(max(calculatedSize, Constants.OKHTTP_CACHE_MIN_SIZE), Constants.OKHTTP_CACHE_MAX_SIZE)

        return Cache(cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        authenticationInterceptor: AuthenticationInterceptor,
        responseErrorHandleInterceptor: ResponseErrorHandleInterceptor,
        cacheInterceptor: CacheInterceptor,
        cache: Cache
    ): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
        .writeTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(authenticationInterceptor)
        .addInterceptor(responseErrorHandleInterceptor)
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(cacheInterceptor)
        .cache(cache)
        .build()

    @Provides
    @Named(Constants.INJECT_NAMED_KOTLINX_SERIALIZATION)
    fun provideKotlinxSerializationJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    @RetrofitRiotAsia
    fun provideAccountRetrofit(
        httpClient: OkHttpClient,
        @Named(Constants.INJECT_NAMED_KOTLINX_SERIALIZATION) json: Json,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.ASIA_ACCOUNT_URL)
        .client(httpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    @Provides
    @Singleton
    @RetrofitRiotKorea
    fun provideRiotKoreaRetrofit(
        httpClient: OkHttpClient,
        @Named(Constants.INJECT_NAMED_KOTLINX_SERIALIZATION) json: Json,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.KR_BASE_URL)
        .client(httpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    @Provides
    @Singleton
    fun provideRiotAsiaApi(@RetrofitRiotAsia retrofit: Retrofit): RiotAsiaApi =
        retrofit.create(RiotAsiaApi::class.java)

    @Provides
    @Singleton
    fun provideRiotKoreaApi(@RetrofitRiotKorea retrofit: Retrofit): RiotKoreaApi =
        retrofit.create(RiotKoreaApi::class.java)

}