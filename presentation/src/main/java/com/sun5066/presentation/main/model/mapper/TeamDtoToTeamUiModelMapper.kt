package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.TeamDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.TeamUiModel
import javax.inject.Inject

class TeamDtoToTeamUiModelMapper @Inject constructor(
    private val banMapper: BanDtoToBanUiModelMapper,
    private val objectivesMapper: ObjectivesDtoToObjectivesUiModelMapper
) : EntityMapper<TeamDto, TeamUiModel> {
    override fun toModel(entity: TeamDto): TeamUiModel {
        return TeamUiModel(
            bans = entity.bans.map(banMapper::toModel),
            objectives = objectivesMapper.toModel(entity.objectives),
            teamId = entity.teamId,
            win = entity.win
        )
    }
}