package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.ParticipantDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.Participant
import javax.inject.Inject

class ParticipantDtoToParticipantMapper @Inject constructor() : EntityMapper<ParticipantDto, Participant> {
    override fun toModel(entity: ParticipantDto): Participant {
        return Participant(
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