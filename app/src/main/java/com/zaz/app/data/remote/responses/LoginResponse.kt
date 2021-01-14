package com.zaz.app.data.remote.responses

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val avatar: String,
    val email: String,
    @SerializedName("nome") val name: String,
    val id: Long,
    @SerializedName("msg") override val message: String,
    override val status: String,
    val raio: String,
    @SerializedName("url_link") val urlLink: String
): BaseResponse()