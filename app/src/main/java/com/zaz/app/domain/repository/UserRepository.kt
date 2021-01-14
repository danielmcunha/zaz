package com.zaz.app.domain.repository

import com.zaz.app.data.remote.SimpleResult
import com.zaz.app.domain.models.UserInfo
import com.zaz.app.domain.models.UserSummary

interface UserRepository {

    suspend fun getFollowers(userId: Long): SimpleResult<List<UserSummary>>
    suspend fun getFollowing(userId: Long): SimpleResult<List<UserSummary>>
    suspend fun getUserInfo(userId: Long): SimpleResult<UserInfo>
}