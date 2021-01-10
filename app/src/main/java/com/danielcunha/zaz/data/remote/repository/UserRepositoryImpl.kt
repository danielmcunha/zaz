package com.danielcunha.zaz.data.remote.repository

import com.danielcunha.zaz.data.remote.ApiService
import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.data.remote.safe
import com.danielcunha.zaz.domain.mappers.toDomain
import com.danielcunha.zaz.domain.models.UserInfo
import com.danielcunha.zaz.domain.models.UserSummary
import com.danielcunha.zaz.domain.repository.UserRepository

class UserRepositoryImpl(private val apiService: ApiService) : UserRepository {

    override suspend fun getFollowers(userId: Long): SimpleResult<List<UserSummary>> {
        return safe {
            apiService.getFollowers(userId).toDomain()
        }
    }

    override suspend fun getFollowing(userId: Long): SimpleResult<List<UserSummary>> {
        return safe {
            apiService.getFollowing(userId).toDomain()
        }
    }

    override suspend fun getUserInfo(userId: Long): SimpleResult<UserInfo> {
        return safe {
            apiService.getUserInfo(userId).toDomain()
        }
    }
}