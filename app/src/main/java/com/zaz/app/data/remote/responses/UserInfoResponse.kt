package com.zaz.app.data.remote.responses

import com.google.gson.annotations.SerializedName

data class UserInfoResponse(
    val id: Long?,
    val avatar: String?,
    @SerializedName("celular") val phone: String?,
    val email: String?,
    @SerializedName("nome") val name: String?
)