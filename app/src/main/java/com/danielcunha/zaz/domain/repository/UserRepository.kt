package com.danielcunha.zaz.domain.repository

import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.domain.models.UserInfo
import com.danielcunha.zaz.domain.models.UserSummary

interface UserRepository {

    suspend fun getFollowers(userId: Long): SimpleResult<List<UserSummary>>
    suspend fun getFollowing(userId: Long): SimpleResult<List<UserSummary>>
    suspend fun getUserInfo(userId: Long): SimpleResult<UserInfo>
}