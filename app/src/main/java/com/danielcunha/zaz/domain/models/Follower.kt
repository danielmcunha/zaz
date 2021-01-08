package com.danielcunha.zaz.domain.models

data class Follower(
    val avatar: String,
    val friendsAmount: Int,
    val id: Long,
    val name: String
)