package com.sun5066.domain.usecase

import com.sun5066.domain.model.MatchDto
import com.sun5066.domain.repository.RiotRepository
import javax.inject.Inject

class GetMatchesUseCase @Inject constructor(
    private val riotRepository: RiotRepository
) {
    suspend operator fun invoke(
        puuId: String,
        start: Int,
        count: Int,
        startTime: Long? = null,
        endTime: Long? = null,
        queue: Int? = null,
        type: String? = null
    ): List<MatchDto> {
        return riotRepository.getMatches(puuId, start, count, startTime, endTime, queue, type)
    }
}