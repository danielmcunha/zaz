package com.danielcunha.zaz.domain.repository

import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.data.remote.requests.CreateUserRequest
import com.danielcunha.zaz.data.remote.requests.LoginRequest
import com.danielcunha.zaz.domain.models.User

interface AuthRepository {

    suspend fun login(loginRequest: LoginRequest) : SimpleResult<User>
    suspend fun createUser(createNewUserRequest: CreateUserRequest) : SimpleResult<User>
}