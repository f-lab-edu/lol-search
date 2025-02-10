package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.MatchDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.MatchInfo
import javax.inject.Inject

class MatchDtoToMatchInfoMapper @Inject constructor(
    private val metadataMapper: MetadataDtoToMetadataInfoMapper,
    private val infoMapper: InfoDtoToGameInfoMapper
) : EntityMapper<MatchDto, MatchInfo> {
    override fun toModel(entity: MatchDto): MatchInfo {
        return MatchInfo(
            metadata = metadataMapper.toModel(entity.metadata),
            info = infoMapper.toModel(entity.info)
        )
    }
}