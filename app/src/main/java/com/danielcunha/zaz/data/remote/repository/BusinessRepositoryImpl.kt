package com.danielcunha.zaz.data.remote.repository

import com.danielcunha.zaz.data.remote.ApiService
import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.data.remote.requests.CreateBusinessRequest
import com.danielcunha.zaz.data.remote.safe
import com.danielcunha.zaz.data.remote.valid
import com.danielcunha.zaz.domain.mappers.toDomain
import com.danielcunha.zaz.domain.models.Business
import com.danielcunha.zaz.domain.repository.BusinessRepository

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

    override suspend fun createBusiness(createBusinessRequest: CreateBusinessRequest): SimpleResult<Unit> {
        return safe {
            apiService.createBusiness(createBusinessRequest)
        }
    }
}