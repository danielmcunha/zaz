package com.danielcunha.zaz.domain.repository

import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.domain.models.Follower

interface FollowersRepository {

    suspend fun getFollowers(userId: Long): SimpleResult<List<Follower>>
}