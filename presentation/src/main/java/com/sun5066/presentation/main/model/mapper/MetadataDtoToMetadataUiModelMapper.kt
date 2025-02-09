package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.MetadataDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.MetadataUiModel
import javax.inject.Inject

class MetadataDtoToMetadataUiModelMapper @Inject constructor() : EntityMapper<MetadataDto, MetadataUiModel> {
    override fun toModel(entity: MetadataDto): MetadataUiModel {
        return MetadataUiModel(
            dataVersion = entity.dataVersion,
            matchId = entity.matchId,
            participants = entity.participants
        )
    }
}