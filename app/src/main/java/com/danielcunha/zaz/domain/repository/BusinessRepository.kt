package com.danielcunha.zaz.domain.repository

import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.data.remote.requests.CreateBusinessRequest
import com.danielcunha.zaz.domain.models.Business

interface BusinessRepository {

    suspend fun getAllBusiness(offset: Int, limit: Int): SimpleResult<List<Business>>
    suspend fun getBusiness(businessId: Long): SimpleResult<Business>
    suspend fun createBusiness(createBusinessRequest: CreateBusinessRequest): SimpleResult<Any>
}