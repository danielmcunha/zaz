package com.danielcunha.zaz.data.remote.requests

import com.google.gson.annotations.SerializedName

data class CreateUserRequest(
    val email: String,
    @SerializedName("id_padrinho") val sponsorId: Long,
    @SerializedName("nome") val name: String,
    @SerializedName("url_padrinho") val sponsorEmail: String,
    val password: String
)