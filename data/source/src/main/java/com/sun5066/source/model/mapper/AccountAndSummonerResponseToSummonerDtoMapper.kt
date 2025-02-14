package com.sun5066.source.model.mapper

import com.sun5066.domain.model.SummonerDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.source.model.AccountResponse
import com.sun5066.source.model.SummonerResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccountAndSummonerResponseToSummonerDtoMapper @Inject constructor() : EntityMapper<Pair<AccountResponse, SummonerResponse>, SummonerDto> {
    override fun toModel(entity: Pair<AccountResponse, SummonerResponse>): SummonerDto {
        val (account, summoner) = entity
        return SummonerDto(
            id = summoner.id,
            puuId = summoner.puuId,
            accountId = summoner.accountId,
            profileIconId = summoner.profileIconId,
            revisionDate = summoner.revisionDate,
            summonerLevel = summoner.summonerLevel,
            gameName = account.gameName,
            tagLine = account.tagLine
        )
    }
}