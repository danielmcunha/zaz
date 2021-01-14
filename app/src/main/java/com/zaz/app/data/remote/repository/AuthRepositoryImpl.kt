package com.zaz.app.data.remote.repository

import com.zaz.app.data.remote.*
import com.zaz.app.data.remote.requests.CreateUserRequest
import com.zaz.app.data.remote.requests.LoginRequest
import com.zaz.app.domain.mappers.toDomain
import com.zaz.app.domain.models.User
import com.zaz.app.domain.repository.AuthRepository

class AuthRepositoryImpl(private val apiService: ApiService) : AuthRepository {

    override suspend fun login(loginRequest: LoginRequest): SimpleResult<User> {
        return safe {
            valid { apiService.login(loginRequest) }.toDomain()
        }
    }

    override suspend fun createUser(createNewUserRequest: CreateUserRequest): SimpleResult<User> {
        return safe {
            valid { apiService.createUser(createNewUserRequest) }.toDomain()
        }
    }
}