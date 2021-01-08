package com.danielcunha.zaz.data.remote.requests

import com.google.gson.annotations.SerializedName

data class CreateBusinessRequest(
    @SerializedName("businessCatgId") val businessCategoryId: Long,
    @SerializedName("cadastrosId") val registrationId: Long,
    @SerializedName("descricao") val description: String,
    @SerializedName("idCategoria") val categoryId: Long,
    val latitude: Int,
    val longitude: Int,
    @SerializedName("titulo") val title: String,
    @SerializedName("valor") val value: String,
)