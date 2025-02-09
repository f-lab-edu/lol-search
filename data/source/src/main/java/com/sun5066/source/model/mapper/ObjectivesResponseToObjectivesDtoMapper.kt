package com.sun5066.source.model.mapper

import com.sun5066.domain.model.ObjectivesDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.source.model.ObjectivesResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ObjectivesResponseToObjectivesDtoMapper @Inject constructor(
    private val objectiveMapper: ObjectiveResponseToObjectiveDtoMapper
) : EntityMapper<ObjectivesResponse, ObjectivesDto> {
    override fun toModel(entity: ObjectivesResponse): ObjectivesDto {
        return ObjectivesDto(
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