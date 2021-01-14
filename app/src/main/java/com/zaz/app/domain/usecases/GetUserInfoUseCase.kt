package com.zaz.app.domain.usecases

import com.zaz.app.data.remote.SimpleResult
import com.zaz.app.domain.models.UserInfo
import com.zaz.app.domain.repository.UserRepository

class GetUserInfoUseCase(
    private val userRepository: UserRepository
) : BaseUseCase<Long, UserInfo> {

    override suspend fun invoke(params: Long): SimpleResult<UserInfo> {
        return userRepository.getUserInfo(params)
    }
}