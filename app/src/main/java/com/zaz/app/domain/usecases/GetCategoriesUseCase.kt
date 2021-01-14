package com.zaz.app.domain.usecases

import com.zaz.app.data.remote.SimpleResult
import com.zaz.app.domain.models.Category
import com.zaz.app.domain.repository.BusinessRepository

class GetCategoriesUseCase(
    private val businessRepository: BusinessRepository,
) : BaseUseCase<Any?, Any> {

    override suspend operator fun invoke(params: Any?): SimpleResult<List<Category>> {
        return businessRepository.getCategories()
    }
}