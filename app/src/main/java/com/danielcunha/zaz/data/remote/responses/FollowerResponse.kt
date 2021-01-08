package com.danielcunha.zaz.data.remote.responses

import com.google.gson.annotations.SerializedName

data class FollowerResponse(
    @SerializedName("avatar") val avatar: String,
    @SerializedName("friendsAmount") val friendsAmount: Int,
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String
)