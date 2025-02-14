package com.sun5066.source.model.mapper

import com.sun5066.domain.model.ParticipantDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.source.model.ParticipantResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ParticipantResponseToParticipantDtoMapper @Inject constructor() :
    EntityMapper<ParticipantResponse, ParticipantDto> {
    override fun toModel(entity: ParticipantResponse): ParticipantDto {
        return ParticipantDto(
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