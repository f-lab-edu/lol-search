package com.sun5066.source.model.mapper

import com.sun5066.source.model.BanResponse
import com.sun5066.domain.model.BanDto
import com.sun5066.domain.model.mapper.EntityMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BanResponseToBanDtoMapper @Inject constructor() : EntityMapper<BanResponse, BanDto> {
    override fun toModel(entity: BanResponse): BanDto {
        return BanDto(
            championId = entity.championId,
            pickTurn = entity.pickTurn
        )
    }
}