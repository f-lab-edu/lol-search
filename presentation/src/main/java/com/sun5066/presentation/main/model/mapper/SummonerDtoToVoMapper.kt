package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.SummonerDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.Summoner
import javax.inject.Inject

class SummonerDtoToVoMapper @Inject constructor() : EntityMapper<SummonerDto, Summoner> {
    override fun toModel(entity: SummonerDto): Summoner = Summoner(
        id = entity.id,
        puuId = entity.puuId,
        accountId = entity.accountId,
        profileIconId = entity.profileIconId,
        revisionDate = entity.revisionDate,
        summonerLevel = entity.summonerLevel,
    )
}