package com.danielcunha.zaz.domain.usecases

import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.domain.models.Follower
import com.danielcunha.zaz.domain.repository.FollowersRepository

class GetFollowersUseCase(
    private val followersRepository: FollowersRepository
) : BaseUseCase<Long, List<Follower>> {

    override suspend fun invoke(params: Long): SimpleResult<List<Follower>> {
        return followersRepository.getFollowers(params)
    }
}