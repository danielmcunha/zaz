package com.danielcunha.zaz.data.remote

import com.danielcunha.zaz.data.remote.requests.CreateUserRequest
import com.danielcunha.zaz.data.remote.requests.LoginRequest
import com.danielcunha.zaz.data.remote.responses.CreateUserResponse
import com.danielcunha.zaz.data.remote.responses.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/v2/map/login")
    suspend fun login(@Body requestBody: LoginRequest): LoginResponse

    @POST("/v2/map/create/user")
    suspend fun createUser(@Body requestBody: CreateUserRequest): CreateUserResponse
}