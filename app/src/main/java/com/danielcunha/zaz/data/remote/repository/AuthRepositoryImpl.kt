package com.danielcunha.zaz.data.remote.repository

import com.danielcunha.zaz.data.remote.*
import com.danielcunha.zaz.data.remote.requests.CreateUserRequest
import com.danielcunha.zaz.data.remote.requests.LoginRequest
import com.danielcunha.zaz.domain.mappers.toDomain
import com.danielcunha.zaz.domain.models.User
import com.danielcunha.zaz.domain.repository.AuthRepository

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