package com.danielcunha.zaz.domain.usecases

import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.data.remote.requests.CreateUserRequest
import com.danielcunha.zaz.domain.models.AuthUser
import com.danielcunha.zaz.domain.models.User
import com.danielcunha.zaz.domain.repository.AuthRepository

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