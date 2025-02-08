package com.sun5066.source.repository

import com.sun5066.domain.model.SummonerDto
import com.sun5066.domain.repository.RiotRepository
import com.sun5066.source.RestApiDataSource
import com.sun5066.source.model.mapper.SummonerResponseToDtoMapper
import javax.inject.Inject

class RiotRepositoryImpl @Inject constructor(
    private val restApiDataSource: RestApiDataSource,
    private val summonerResponseToDtoMapper: SummonerResponseToDtoMapper,
) : RiotRepository {

    override suspend fun getSummoner(gameName: String, tagLine: String): SummonerDto {
        val account = restApiDataSource.getAccount(gameName, tagLine)

        return restApiDataSource.getSummoner(account.puuId).let(summonerResponseToDtoMapper::toModel)
    }

}