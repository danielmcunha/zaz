package com.danielcunha.zaz.domain.usecases

import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.data.remote.requests.LoginRequest
import com.danielcunha.zaz.domain.models.AuthUser
import com.danielcunha.zaz.domain.models.User
import com.danielcunha.zaz.domain.repository.AuthRepository

class LoginUseCase(
    private val authRepository: AuthRepository,
    private val authUser: AuthUser,
) : BaseUseCase<LoginRequest, User> {

    override suspend operator fun invoke(params: LoginRequest): SimpleResult<User> {
        return authRepository.login(params).takeSuccess { user ->
            authUser.user = user
        }
    }
}