package com.sun5066.source.model.mapper

import com.sun5066.source.model.MetadataResponse
import com.sun5066.domain.model.MetadataDto
import com.sun5066.domain.model.mapper.EntityMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MetadataResponseToMetadataDtoMapper @Inject constructor() : EntityMapper<MetadataResponse, MetadataDto> {
    override fun toModel(entity: MetadataResponse): MetadataDto {
        return MetadataDto(
            dataVersion = entity.dataVersion,
            matchId = entity.matchId,
            participants = entity.participants
        )
    }
}