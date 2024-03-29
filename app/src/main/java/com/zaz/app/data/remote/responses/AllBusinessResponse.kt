package com.zaz.app.data.remote.responses

import com.google.gson.annotations.SerializedName

data class AllBusinessResponse(
    @SerializedName("content") val allBusiness: List<BusinessResponse>
)