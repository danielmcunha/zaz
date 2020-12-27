package com.danielcunha.zaz.data.remote

import com.danielcunha.zaz.data.remote.requests.CreateUserRequest
import com.danielcunha.zaz.data.remote.requests.LoginRequest
import com.danielcunha.zaz.data.remote.responses.AllBusinessResponse
import com.danielcunha.zaz.data.remote.responses.BusinessResponse
import com.danielcunha.zaz.data.remote.responses.CreateUserResponse
import com.danielcunha.zaz.data.remote.responses.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("/v2/map/login")
    suspend fun login(@Body requestBody: LoginRequest): LoginResponse

    @POST("/v2/map/create/user")
    suspend fun createUser(@Body requestBody: CreateUserRequest): CreateUserResponse

    @GET("/v2/map/business/{offset}/{limit}")
    suspend fun getAllBusiness(@Path("offset") offset: Int, @Path("limit") limit: Int): AllBusinessResponse

    @GET("/v2/map/business/{businessId}")
    suspend fun getBusiness(@Path("businessId") businessId: Long): BusinessResponse
}