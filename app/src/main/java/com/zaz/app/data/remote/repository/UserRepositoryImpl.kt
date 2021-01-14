package com.zaz.app.data.remote.repository

import com.zaz.app.data.remote.ApiService
import com.zaz.app.data.remote.SimpleResult
import com.zaz.app.data.remote.safe
import com.zaz.app.domain.mappers.toDomain
import com.zaz.app.domain.models.UserInfo
import com.zaz.app.domain.models.UserSummary
import com.zaz.app.domain.repository.UserRepository

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