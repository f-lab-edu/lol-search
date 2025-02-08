package com.sun5066.domain.usecase

import com.sun5066.domain.repository.RiotRepository
import javax.inject.Inject

class GetSummonerUseCase @Inject constructor(
    private val riotRepository: RiotRepository
) {
    suspend operator fun invoke(gameName: String, tagLine: String) =
        riotRepository.getSummoner(gameName, tagLine)
}