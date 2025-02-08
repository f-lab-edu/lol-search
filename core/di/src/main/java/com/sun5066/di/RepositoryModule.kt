package com.sun5066.di

import com.sun5066.domain.repository.RiotRepository
import com.sun5066.source.repository.RiotRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindAccountRepository(accountRepository: RiotRepositoryImpl): RiotRepository
}