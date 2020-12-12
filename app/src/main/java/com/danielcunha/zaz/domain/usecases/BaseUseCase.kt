package com.danielcunha.zaz.domain.usecases

import com.danielcunha.zaz.data.remote.SimpleResult

interface BaseUseCase<in Parameter, out Result> {

    suspend operator fun invoke(params: Parameter): SimpleResult<Result>
}