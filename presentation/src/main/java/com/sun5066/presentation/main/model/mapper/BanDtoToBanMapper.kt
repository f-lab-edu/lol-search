package com.sun5066.presentation.main.model.mapper

import com.sun5066.domain.model.BanDto
import com.sun5066.domain.model.mapper.EntityMapper
import com.sun5066.presentation.main.model.Ban
import javax.inject.Inject

class BanDtoToBanMapper @Inject constructor() : EntityMapper<BanDto, Ban> {
    override fun toModel(entity: BanDto): Ban {
        return Ban(
            championId = entity.championId,
            pickTurn = entity.pickTurn
        )
    }
}