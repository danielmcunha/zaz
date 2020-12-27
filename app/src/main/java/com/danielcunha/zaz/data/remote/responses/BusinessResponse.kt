package com.danielcunha.zaz.data.remote.responses

import com.google.gson.annotations.SerializedName

data class BusinessResponse(
    val avatar: String,
    @SerializedName("celular") val phone: String,
    @SerializedName("comp") val comp: Long,
    @SerializedName("data") val date: String,
    @SerializedName("descricao") val description: String,
    @SerializedName("email") val email: String,
    @SerializedName("horario") val time: String,
    val id: Long,
    @SerializedName("id_categoria") val categoryId: Long,
    val latitude: Double,
    val longitude: Double,
    @SerializedName("media") val average: Double,
    @SerializedName("nome") val name: String,
    @SerializedName("nome_categoria") val categoryName: String,
    @SerializedName("titulo") val title: String, val url: List<String>,
    @SerializedName("valor") val value: String
)