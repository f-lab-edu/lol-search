package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.TeamDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.Team
import javax.inject.Inject

class TeamDtoToTeamMapper @Inject constructor(
    private val banMapper: BanDtoToBanMapper,
    private val objectivesMapper: ObjectivesDtoToObjectivesMapper
) : EntityMapper<TeamDto, Team> {
    override fun toModel(entity: TeamDto): Team {
        return Team(
            bans = entity.bans.map(banMapper::toModel),
            objectives = objectivesMapper.toModel(entity.objectives),
            teamId = entity.teamId,
            win = entity.win
        )
    }
}