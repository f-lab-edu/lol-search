package com.sun5066.domain.repository

import com.sun5066.domain.model.AccountDto

interface AccountRepository {
    suspend fun getAccount(gameName: String, tagLine: String): AccountDto
}