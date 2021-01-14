package com.zaz.app.domain.usecases

import com.zaz.app.data.remote.SimpleResult

interface BaseUseCase<in Parameter, out Result> {

    suspend operator fun invoke(params: Parameter): SimpleResult<Result>
}