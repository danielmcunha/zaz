package com.danielcunha.zaz.domain.usecases

import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.domain.models.Business
import com.danielcunha.zaz.domain.repository.BusinessRepository

class GetBusinessUseCase(
    private val businessRepository: BusinessRepository
) : BaseUseCase<Long, Business> {

    override suspend fun invoke(params: Long): SimpleResult<Business> {
        return businessRepository.getBusiness(params)
    }
}