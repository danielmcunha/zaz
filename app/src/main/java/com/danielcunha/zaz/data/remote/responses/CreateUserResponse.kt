package com.danielcunha.zaz.data.remote.responses

import com.google.gson.annotations.SerializedName

data class CreateUserResponse(
    val avatar: String,
    val email: String,
    val id: Long,
    @SerializedName("msg") override val message: String,
    @SerializedName("nome") val name: String,
    override val status: String,
    @SerializedName("url_link") val urlLink: String,
): BaseResponse()