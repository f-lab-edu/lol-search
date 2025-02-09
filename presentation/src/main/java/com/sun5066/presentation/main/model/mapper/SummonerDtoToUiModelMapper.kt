package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.SummonerDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.SummonerUiModel
import javax.inject.Inject

class SummonerDtoToUiModelMapper @Inject constructor() : EntityMapper<SummonerDto, SummonerUiModel> {
    override fun toModel(entity: SummonerDto): SummonerUiModel = SummonerUiModel(
        id = entity.id,
        puuId = entity.puuId,
        accountId = entity.accountId,
        profileIconId = entity.profileIconId,
        revisionDate = entity.revisionDate,
        summonerLevel = entity.summonerLevel,
        gameName = entity.gameName,
        tagLine = entity.tagLine
    )
}