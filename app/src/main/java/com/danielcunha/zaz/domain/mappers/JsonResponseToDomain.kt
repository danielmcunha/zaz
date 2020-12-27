package com.danielcunha.zaz.domain.mappers

import com.danielcunha.zaz.data.remote.responses.AllBusinessResponse
import com.danielcunha.zaz.data.remote.responses.BusinessResponse
import com.danielcunha.zaz.data.remote.responses.CreateUserResponse
import com.danielcunha.zaz.data.remote.responses.LoginResponse
import com.danielcunha.zaz.domain.models.Business
import com.danielcunha.zaz.domain.models.User

internal fun LoginResponse.toDomain(): User {
    return User(avatar, name, email, id)
}

internal fun CreateUserResponse.toDomain(): User {
    return User(avatar, name, email, id)
}

internal fun AllBusinessResponse.toDomain(): List<Business> {
    return allBusiness.map { it.toDomain() }
}

internal fun BusinessResponse.toDomain(): Business {
    return Business(
        avatar,
        phone,
        comp,
        date,
        description,
        email,
        time,
        id,
        categoryId,
        latitude,
        longitude,
        average,
        name,
        categoryName,
        title,
        url,
        value
    )
}