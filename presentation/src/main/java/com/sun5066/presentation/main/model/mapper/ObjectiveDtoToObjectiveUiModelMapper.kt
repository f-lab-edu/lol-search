package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.ObjectiveDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.ObjectiveUiModel
import javax.inject.Inject

class ObjectiveDtoToObjectiveUiModelMapper @Inject constructor() : EntityMapper<ObjectiveDto, ObjectiveUiModel> {
    override fun toModel(entity: ObjectiveDto): ObjectiveUiModel {
        return ObjectiveUiModel(
            first = entity.first,
            kills = entity.kills
        )
    }
}