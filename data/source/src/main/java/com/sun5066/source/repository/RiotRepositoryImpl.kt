package com.sun5066.source.repository

import com.sun5066.domain.model.MatchDto
import com.sun5066.domain.model.SummonerDto
import com.sun5066.domain.repository.RiotRepository
import com.sun5066.source.RestApiDataSource
import com.sun5066.source.model.mapper.AccountAndSummonerResponseToSummonerDtoMapper
import com.sun5066.source.model.mapper.MatchResponseToMatchDtoMapper
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

class RiotRepositoryImpl @Inject constructor(
    private val restApiDataSource: RestApiDataSource,
    private val accountAndSummonerResponseToSummonerDtoMapper: AccountAndSummonerResponseToSummonerDtoMapper,
    private val matchResponseToMatchDtoMapper: MatchResponseToMatchDtoMapper
) : RiotRepository {

    override suspend fun getSummoner(gameName: String, tagLine: String): SummonerDto {
        val account = restApiDataSource.getAccount(gameName, tagLine)
        val summoner = restApiDataSource.getSummoner(account.puuId)

        return (account to summoner).let(accountAndSummonerResponseToSummonerDtoMapper::toModel)
    }

    override suspend fun getMatches(
        puuId: String,
        start: Int,
        count: Int,
        startTime: Long?,
        endTime: Long?,
        queue: Int?,
        type: String?
    ): List<MatchDto> {
        val ids = restApiDataSource.getMatchIds(puuId, start, count, startTime, endTime, queue, type)

        val matches = supervisorScope {
            ids.map { id -> async { restApiDataSource.getMatch(id) } }
                .awaitAll()
                .map(matchResponseToMatchDtoMapper::toModel)
        }

        return matches
    }

}