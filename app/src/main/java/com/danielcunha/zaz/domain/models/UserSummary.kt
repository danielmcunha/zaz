package com.danielcunha.zaz.domain.models

data class UserSummary(
    val avatar: String,
    val friendsAmount: Int,
    val id: Long,
    val name: String
)