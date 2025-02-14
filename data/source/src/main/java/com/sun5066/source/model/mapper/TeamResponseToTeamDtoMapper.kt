package com.sun5066.source.model.mapper

import com.sun5066.domain.model.TeamDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.source.model.TeamResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamResponseToTeamDtoMapper @Inject constructor(
    private val banMapper: BanResponseToBanDtoMapper,
    private val objectivesMapper: ObjectivesResponseToObjectivesDtoMapper
) : EntityMapper<TeamResponse, TeamDto> {
    override fun toModel(entity: TeamResponse): TeamDto {
        return TeamDto(
            bans = entity.bans.map(banMapper::toModel),
            objectives = objectivesMapper.toModel(entity.objectives),
            teamId = entity.teamId,
            win = entity.win
        )
    }
}