package com.example.domain.dto

data class SportsCategoryDTO(
    val data: List<SportsCategoryDataDTO>?
)

data class SportsCategoryDataDTO(
    val sportsCategoryTitle: String,
    val sportsCategoryImageUrl: Int,
    val sportsCategoryItem: List<SportsCategoryListsDTO>?
)

data class SportsCategoryListsDTO(
    val sportsTitle: String,
    val sportsDescription: String,
    val sportsImageUrl: Int
)
