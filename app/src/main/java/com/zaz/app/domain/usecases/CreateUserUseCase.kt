package com.zaz.app.domain.usecases

import com.zaz.app.data.remote.SimpleResult
import com.zaz.app.data.remote.requests.CreateUserRequest
import com.zaz.app.domain.models.AuthUser
import com.zaz.app.domain.models.User
import com.zaz.app.domain.repository.AuthRepository

class CreateUserUseCase(
    private val authRepository: AuthRepository,
    private val authUser: AuthUser,
) : BaseUseCase<CreateUserRequest, User> {

    override suspend operator fun invoke(params: CreateUserRequest): SimpleResult<User> {
        return authRepository.createUser(params).takeSuccess { user ->
            authUser.user = user
        }
    }
}