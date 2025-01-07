package com.sun5066.source.model.mapper

import com.sun5066.domain.model.AccountDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.source.model.AccountResponse
import javax.inject.Inject

class AccountResponseToDtoMapper @Inject constructor() : EntityMapper<AccountResponse, AccountDto> {
    override fun toModel(entity: AccountResponse): AccountDto = AccountDto(
        puuId = entity.puuId,
        gameName = entity.gameName,
        tagLine = entity.tagLine,
    )
}