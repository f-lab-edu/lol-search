package com.sun5066.rest_api.source

import com.sun5066.rest_api.AccountApi
import com.sun5066.source.AccountDataSource
import com.sun5066.source.model.AccountResponse
import javax.inject.Inject

class AccountDataSourceImpl @Inject constructor(
    private val accountApi: AccountApi
) : AccountDataSource {

    override suspend fun getAccount(gameName: String, tagLine: String): AccountResponse =
        accountApi.getAccount(gameName, tagLine)

}