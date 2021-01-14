package com.zaz.app.domain.models

data class UserSummary(
    val avatar: String,
    val friendsAmount: Int,
    val id: Long,
    val name: String
)