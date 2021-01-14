package com.zaz.app.data.remote.responses

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    val id: Long,
    @SerializedName("idCategoria") val categoryId: Long,
    @SerializedName("nome") val name: String
)