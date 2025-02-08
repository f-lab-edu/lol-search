package com.sun5066.source.model.mapper

import com.sun5066.domain.model.SummonerDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.source.model.SummonerResponse
import javax.inject.Inject

class SummonerResponseToDtoMapper @Inject constructor() : EntityMapper<SummonerResponse, SummonerDto> {
    override fun toModel(entity: SummonerResponse): SummonerDto = SummonerDto(
        id = entity.id,
        puuId = entity.puuId,
        accountId = entity.accountId,
        profileIconId = entity.profileIconId,
        revisionDate = entity.revisionDate,
        summonerLevel = entity.summonerLevel,
    )
}