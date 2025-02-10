package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.InfoDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.GameInfo
import javax.inject.Inject

class InfoDtoToGameInfoMapper @Inject constructor(
    private val participantMapper: ParticipantDtoToParticipantMapper,
    private val teamMapper: TeamDtoToTeamMapper
) : EntityMapper<InfoDto, GameInfo> {
    override fun toModel(entity: InfoDto): GameInfo {
        return GameInfo(
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