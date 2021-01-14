package com.zaz.app.domain.usecases

import com.zaz.app.data.remote.SimpleResult
import com.zaz.app.domain.models.Business
import com.zaz.app.domain.repository.BusinessRepository

class GetBusinessUseCase(
    private val businessRepository: BusinessRepository
) : BaseUseCase<Long, Business> {

    override suspend fun invoke(params: Long): SimpleResult<Business> {
        return businessRepository.getBusiness(params)
    }
}