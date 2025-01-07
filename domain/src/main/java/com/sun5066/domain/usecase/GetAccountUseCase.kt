package com.sun5066.domain.usecase

import com.sun5066.domain.repository.AccountRepository
import javax.inject.Inject

class GetAccountUseCase @Inject constructor(
    private val accountRepository: AccountRepository
) {
    suspend operator fun invoke(gameName: String, tagLine: String) =
        accountRepository.getAccount(gameName, tagLine)
}