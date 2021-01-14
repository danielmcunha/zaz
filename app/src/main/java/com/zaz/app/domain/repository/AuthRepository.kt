package com.zaz.app.domain.repository

import com.zaz.app.data.remote.SimpleResult
import com.zaz.app.data.remote.requests.CreateUserRequest
import com.zaz.app.data.remote.requests.LoginRequest
import com.zaz.app.domain.models.User

interface AuthRepository {

    suspend fun login(loginRequest: LoginRequest) : SimpleResult<User>
    suspend fun createUser(createNewUserRequest: CreateUserRequest) : SimpleResult<User>
}