package com.sun5066.source.model.mapper

import com.sun5066.domain.model.InfoDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.source.model.InfoResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InfoResponseToInfoDtoMapper @Inject constructor(
    private val participantMapper: ParticipantResponseToParticipantDtoMapper,
    private val teamMapper: TeamResponseToTeamDtoMapper
) : EntityMapper<InfoResponse, InfoDto> {
    override fun toModel(entity: InfoResponse): InfoDto {
        return InfoDto(
            endOfGameResult = entity.endOfGameResult,
            gameCreation = entity.gameCreation,
            gameDuration = entity.gameDuration,
            gameEndTimestamp = entity.gameEndTimestamp,
            gameId = entity.gameId,
            gameMode = entity.gameMode,
            gameName = entity.gameName,
            gameStartTimestamp = entity.gameStartTimestamp,
            gameType = entity.gameType,
            gameVersion = entity.gameVersion,
            mapId = entity.mapId,
            participants = entity.participants.map(participantMapper::toModel),
            platformId = entity.platformId,
            queueId = entity.queueId,
            teams = entity.teams.map(teamMapper::toModel),
            tournamentCode = entity.tournamentCode
        )
    }
}