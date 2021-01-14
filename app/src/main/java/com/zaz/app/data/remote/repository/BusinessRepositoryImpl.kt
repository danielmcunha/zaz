package com.zaz.app.data.remote.repository

import com.zaz.app.data.remote.ApiService
import com.zaz.app.data.remote.SimpleResult
import com.zaz.app.data.remote.requests.CreateBusinessRequest
import com.zaz.app.data.remote.safe
import com.zaz.app.domain.mappers.toDomain
import com.zaz.app.domain.models.Business
import com.zaz.app.domain.models.Category
import com.zaz.app.domain.repository.BusinessRepository

class BusinessRepositoryImpl(private val apiService: ApiService) : BusinessRepository {

    override suspend fun getAllBusiness(offset: Int, limit: Int): SimpleResult<List<Business>> {
        return safe {
            apiService.getAllBusiness(offset, limit).toDomain()
        }
    }

    override suspend fun getBusiness(businessId: Long): SimpleResult<Business> {
        return safe {
            apiService.getBusiness(businessId).toDomain()
        }
    }

    override suspend fun createBusiness(createBusinessRequest: CreateBusinessRequest): SimpleResult<Long> {
        return safe {
            apiService.createBusiness(createBusinessRequest).toDomain()
        }
    }

    override suspend fun getCategories(): SimpleResult<List<Category>> {
        return safe {
            apiService.getCategories().toDomain()
        }
    }
}