package com.sun5066.di

import com.sun5066.rest_api.source.RestApiDataSourceImpl
import com.sun5066.source.RestApiDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    @Singleton
    fun bindAccountDataSource(accountDataSource: RestApiDataSourceImpl): RestApiDataSource
}