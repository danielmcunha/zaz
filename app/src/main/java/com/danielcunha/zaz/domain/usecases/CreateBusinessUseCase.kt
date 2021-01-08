package com.danielcunha.zaz.domain.usecases

import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.data.remote.requests.CreateBusinessRequest
import com.danielcunha.zaz.domain.repository.BusinessRepository

class CreateBusinessUseCase(
    private val businessRepository: BusinessRepository,
) : BaseUseCase<CreateBusinessRequest, Any> {

    override suspend operator fun invoke(params: CreateBusinessRequest): SimpleResult<Any> {
        return businessRepository.createBusiness(params)
    }
}