package com.zaz.app.domain.usecases

import com.zaz.app.data.remote.SimpleResult
import com.zaz.app.data.remote.requests.AllBusinessRequest
import com.zaz.app.domain.models.Business
import com.zaz.app.domain.repository.BusinessRepository

class GetAllBusinessUseCase(
    private val businessRepository: BusinessRepository
) : BaseUseCase<AllBusinessRequest, List<Business>> {

    override suspend fun invoke(params: AllBusinessRequest): SimpleResult<List<Business>> {
        return businessRepository.getAllBusiness(params.offset, params.limit)
    }
}