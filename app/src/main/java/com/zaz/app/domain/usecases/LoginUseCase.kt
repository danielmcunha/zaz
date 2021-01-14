package com.zaz.app.domain.usecases

import com.zaz.app.data.remote.SimpleResult
import com.zaz.app.data.remote.requests.LoginRequest
import com.zaz.app.domain.models.AuthUser
import com.zaz.app.domain.models.User
import com.zaz.app.domain.repository.AuthRepository

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