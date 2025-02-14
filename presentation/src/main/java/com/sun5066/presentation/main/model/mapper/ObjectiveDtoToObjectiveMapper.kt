package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.ObjectiveDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.Objective
import javax.inject.Inject

class ObjectiveDtoToObjectiveMapper @Inject constructor() : EntityMapper<ObjectiveDto, Objective> {
    override fun toModel(entity: ObjectiveDto): Objective {
        return Objective(
            first = entity.first,
            kills = entity.kills
        )
    }
}