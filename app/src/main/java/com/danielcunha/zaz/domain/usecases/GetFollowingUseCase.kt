package com.danielcunha.zaz.domain.usecases

import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.domain.models.UserSummary
import com.danielcunha.zaz.domain.repository.UserRepository

class GetFollowingUseCase(
    private val userRepository: UserRepository
) : BaseUseCase<Long, List<UserSummary>> {

    override suspend fun invoke(params: Long): SimpleResult<List<UserSummary>> {
        return userRepository.getFollowing(params)
    }
}