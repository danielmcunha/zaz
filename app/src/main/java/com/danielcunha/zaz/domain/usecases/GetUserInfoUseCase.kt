package com.danielcunha.zaz.domain.usecases

import com.danielcunha.zaz.data.remote.SimpleResult
import com.danielcunha.zaz.domain.models.UserInfo
import com.danielcunha.zaz.domain.repository.UserRepository

class GetUserInfoUseCase(
    private val userRepository: UserRepository
) : BaseUseCase<Long, UserInfo> {

    override suspend fun invoke(params: Long): SimpleResult<UserInfo> {
        return userRepository.getUserInfo(params)
    }
}