package com.zaz.app.domain.usecases

import com.zaz.app.data.remote.SimpleResult
import com.zaz.app.data.remote.requests.CreateBusinessRequest
import com.zaz.app.domain.repository.BusinessRepository

class CreateBusinessUseCase(
    private val businessRepository: BusinessRepository,
) : BaseUseCase<CreateBusinessRequest, Long> {

    override suspend operator fun invoke(params: CreateBusinessRequest): SimpleResult<Long> {
        return businessRepository.createBusiness(params)
    }
}