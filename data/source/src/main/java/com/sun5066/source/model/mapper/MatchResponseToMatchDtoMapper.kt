package com.sun5066.source.model.mapper

import com.sun5066.domain.model.MatchDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.source.model.MatchResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MatchResponseToMatchDtoMapper @Inject constructor(
    private val metadataMapper: MetadataResponseToMetadataDtoMapper,
    private val infoMapper: InfoResponseToInfoDtoMapper
) : EntityMapper<MatchResponse, MatchDto> {
    override fun toModel(entity: MatchResponse): MatchDto {
        return MatchDto(
            metadata = metadataMapper.toModel(entity.metadata),
            info = infoMapper.toModel(entity.info)
        )
    }
}