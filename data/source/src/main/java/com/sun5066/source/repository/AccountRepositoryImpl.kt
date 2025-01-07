package com.sun5066.source.repository

import com.sun5066.domain.model.AccountDto
import com.sun5066.domain.repository.AccountRepository
import com.sun5066.source.AccountDataSource
import com.sun5066.source.model.mapper.AccountResponseToDtoMapper
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val accountDataSource: AccountDataSource,
    private val accountResponseToDtoMapper: AccountResponseToDtoMapper,
) : AccountRepository {

    override suspend fun getAccount(gameName: String, tagLine: String): AccountDto =
        accountDataSource.getAccount(gameName, tagLine).let(accountResponseToDtoMapper::toModel)

}