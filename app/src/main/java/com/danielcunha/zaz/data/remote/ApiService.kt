package com.danielcunha.zaz.data.remote

import com.danielcunha.zaz.data.remote.requests.CreateBusinessRequest
import com.danielcunha.zaz.data.remote.requests.CreateUserRequest
import com.danielcunha.zaz.data.remote.requests.LoginRequest
import com.danielcunha.zaz.data.remote.responses.*
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

    @GET("/v2/map/user/followers/{userId}")
    suspend fun getFollowers(@Path("userId") userId: Long): List<FollowerResponse>

    @POST("/v2/map/business/create")
    suspend fun createBusiness(@Body requestBody: CreateBusinessRequest)
}