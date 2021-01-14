package com.zaz.app.domain.repository

import com.zaz.app.data.remote.SimpleResult
import com.zaz.app.data.remote.requests.CreateBusinessRequest
import com.zaz.app.domain.models.Business
import com.zaz.app.domain.models.Category

interface BusinessRepository {

    suspend fun getAllBusiness(offset: Int, limit: Int): SimpleResult<List<Business>>
    suspend fun getBusiness(businessId: Long): SimpleResult<Business>
    suspend fun createBusiness(createBusinessRequest: CreateBusinessRequest): SimpleResult<Long>
    suspend fun getCategories(): SimpleResult<List<Category>>
}