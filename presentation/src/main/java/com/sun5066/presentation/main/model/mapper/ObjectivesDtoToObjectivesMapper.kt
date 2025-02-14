package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.ObjectivesDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.Objectives
import javax.inject.Inject

class ObjectivesDtoToObjectivesMapper @Inject constructor(
    private val objectiveMapper: ObjectiveDtoToObjectiveMapper
) : EntityMapper<ObjectivesDto, Objectives> {
    override fun toModel(entity: ObjectivesDto): Objectives {
        return Objectives(
            atakhan = objectiveMapper.toModel(entity.atakhan),
            baron = objectiveMapper.toModel(entity.baron),
            champion = objectiveMapper.toModel(entity.champion),
            dragon = objectiveMapper.toModel(entity.dragon),
            horde = objectiveMapper.toModel(entity.horde),
            inhibitor = objectiveMapper.toModel(entity.inhibitor),
            riftHerald = objectiveMapper.toModel(entity.riftHerald),
            tower = objectiveMapper.toModel(entity.tower)
        )
    }
}