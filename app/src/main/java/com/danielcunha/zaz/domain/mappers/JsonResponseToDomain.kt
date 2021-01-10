package com.danielcunha.zaz.domain.mappers

import com.danielcunha.zaz.data.remote.responses.*
import com.danielcunha.zaz.domain.models.Business
import com.danielcunha.zaz.domain.models.User
import com.danielcunha.zaz.domain.models.UserInfo
import com.danielcunha.zaz.domain.models.UserSummary

internal fun LoginResponse.toDomain(): User {
    return User(id, avatar, name, email)
}

internal fun CreateUserResponse.toDomain(): User {
    return User(id, avatar, name, email)
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

internal fun List<FollowerResponse>.toDomain(): List<UserSummary> {
    return map {
        UserSummary(
            it.avatar,
            it.friendsAmount,
            it.id,
            it.name
        )
    }
}

@JvmName("toDomainFollowingResponse")
internal fun List<FollowingResponse>.toDomain(): List<UserSummary> {
    return map {
        UserSummary(
            it.avatar,
            it.friendsAmount,
            it.id,
            it.name
        )
    }
}

internal fun UserInfoResponse.toDomain(): UserInfo {
    return UserInfo(
        id, name, avatar, phone, email
    )
}