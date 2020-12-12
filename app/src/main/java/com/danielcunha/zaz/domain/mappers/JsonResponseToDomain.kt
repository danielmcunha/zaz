package com.danielcunha.zaz.domain.mappers

import com.danielcunha.zaz.data.remote.responses.CreateUserResponse
import com.danielcunha.zaz.data.remote.responses.LoginResponse
import com.danielcunha.zaz.domain.models.User

internal fun LoginResponse.toDomain(): User {
    return User(avatar, name, email, id)
}

internal fun CreateUserResponse.toDomain(): User {
    return User(avatar, name, email, id)
}