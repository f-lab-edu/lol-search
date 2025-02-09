package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.MatchDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.MatchUiModel
import javax.inject.Inject

class MatchDtoToMatchUiModelMapper @Inject constructor(
    private val metadataMapper: MetadataDtoToMetadataUiModelMapper,
    private val infoMapper: InfoDtoToInfoUiModelMapper
) : EntityMapper<MatchDto, MatchUiModel> {
    override fun toModel(entity: MatchDto): MatchUiModel {
        return MatchUiModel(
            metadata = metadataMapper.toModel(entity.metadata),
            info = infoMapper.toModel(entity.info)
        )
    }
}