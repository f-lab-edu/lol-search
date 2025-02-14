package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.MetadataDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.MetadataInfo
import javax.inject.Inject

class MetadataDtoToMetadataInfoMapper @Inject constructor() : EntityMapper<MetadataDto, MetadataInfo> {
    override fun toModel(entity: MetadataDto): MetadataInfo {
        return MetadataInfo(
            dataVersion = entity.dataVersion,
            matchId = entity.matchId,
            participants = entity.participants
        )
    }
}