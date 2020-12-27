package com.danielcunha.zaz.domain.usecases

import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.data.remote.requests.AllBusinessRequest
import com.danielcunha.zaz.domain.models.Business
import com.danielcunha.zaz.domain.repository.BusinessRepository

class GetAllBusinessUseCase(
    private val businessRepository: BusinessRepository
) : BaseUseCase<AllBusinessRequest, List<Business>> {

    override suspend fun invoke(request: AllBusinessRequest): SimpleResult<List<Business>> {
        return businessRepository.getAllBusiness(request.offset, request.limit)
    }
}