package com.sun5066.source.model.mapper

import com.sun5066.source.model.ObjectiveResponse
import com.sun5066.domain.model.ObjectiveDto
import com.sun5066.domain.model.mapper.EntityMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ObjectiveResponseToObjectiveDtoMapper @Inject constructor() : EntityMapper<ObjectiveResponse, ObjectiveDto> {
    override fun toModel(entity: ObjectiveResponse): ObjectiveDto {
        return ObjectiveDto(
            first = entity.first,
            kills = entity.kills
        )
    }
}