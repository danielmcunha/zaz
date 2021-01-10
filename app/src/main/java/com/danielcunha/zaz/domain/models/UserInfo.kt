package com.danielcunha.zaz.domain.models

data class UserInfo(
    val id: Long,
    val name: String,
    val avatar: String,
    val phone: String,
    val email: String
)