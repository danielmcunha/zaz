package com.danielcunha.zaz.domain.models

data class Business(
    val avatar: String,
    val phone: String,
    val comp: Long,
    val date: String,
    val description: String,
    val email: String,
    val time: String,
    val id: Long,
    val categoryId: Long,
    val latitude: Double,
    val longitude: Double,
    val average: Double,
    val name: String,
    val categoryName: String,
    val title: String, val url: List<String>,
    val value: String
)