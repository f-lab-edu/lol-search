package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.ParticipantDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.ParticipantUiModel
import javax.inject.Inject

class ParticipantDtoToParticipantUiModelMapper @Inject constructor() : EntityMapper<ParticipantDto, ParticipantUiModel> {
    override fun toModel(entity: ParticipantDto): ParticipantUiModel {
        return ParticipantUiModel(
            summonerName = entity.summonerName,
            individualPosition = entity.individualPosition,
            totalDamageDealtToChampions = entity.totalDamageDealtToChampions,
            win = entity.win,
            kills = entity.kills,
            assists = entity.assists,
            deaths = entity.deaths,
            champExperience = entity.champExperience,
            champLevel = entity.champLevel,
            championId = entity.championId,
            championName = entity.championName,
            championTransform = entity.championTransform,
        )
    }
}