package com.example.data.dataSource

import com.example.data.model.SportsCategoryEntity

interface SportsDataSource {
    suspend fun fetchSportsCategories(): SportsCategoryEntity
}