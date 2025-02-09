package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.BanDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.BanUiModel
import javax.inject.Inject

class BanDtoToBanUiModelMapper @Inject constructor() : EntityMapper<BanDto, BanUiModel> {
    override fun toModel(entity: BanDto): BanUiModel {
        return BanUiModel(
            championId = entity.championId,
            pickTurn = entity.pickTurn
        )
    }
}