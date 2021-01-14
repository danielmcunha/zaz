package com.zaz.app.domain.mappers

import com.zaz.app.data.remote.responses.*
import com.zaz.app.domain.models.*

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
        id ?: 0L, name.orEmpty(), avatar.orEmpty(), phone.orEmpty(), email.orEmpty()
    )
}

internal fun CreateBusinessResponse.toDomain(): Long {
    return businessId
}

@JvmName("toDomainCategoryResponse")
internal fun List<CategoryResponse>.toDomain(): List<Category> {
    return map {
        Category(
            it.id,
            it.categoryId,
            it.name
        )
    }
}