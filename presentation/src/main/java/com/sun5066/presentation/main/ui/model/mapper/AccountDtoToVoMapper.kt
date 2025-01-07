package com.sun5066.presentation.main.ui.model.mapper

import com.sun5066.domain.model.AccountDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.ui.model.Account
import javax.inject.Inject

class AccountDtoToVoMapper @Inject constructor() : EntityMapper<AccountDto, Account> {
    override fun toModel(entity: AccountDto): Account = Account(
        puuId = entity.puuId,
        gameName = entity.gameName,
        tagLine = entity.tagLine
    )
}