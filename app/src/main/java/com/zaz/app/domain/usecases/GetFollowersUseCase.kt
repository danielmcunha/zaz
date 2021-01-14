package com.zaz.app.domain.usecases

import com.zaz.app.data.remote.SimpleResult
import com.zaz.app.domain.models.UserSummary
import com.zaz.app.domain.repository.UserRepository

class GetFollowersUseCase(
    private val userRepository: UserRepository
) : BaseUseCase<Long, List<UserSummary>> {

    override suspend fun invoke(params: Long): SimpleResult<List<UserSummary>> {
        return userRepository.getFollowers(params)
    }
}