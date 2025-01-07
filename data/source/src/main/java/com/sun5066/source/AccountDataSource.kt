package com.sun5066.source

import com.sun5066.source.model.AccountResponse

interface AccountDataSource {
    suspend fun getAccount(gameName: String, tagLine: String): AccountResponse
}