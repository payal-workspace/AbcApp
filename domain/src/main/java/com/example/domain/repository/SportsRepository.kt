package com.example.domain.repository

import com.example.domain.utils.Resource
import com.example.domain.dto.SportsCategoryDTO

interface SportsRepository {
    suspend fun getSportsCategories(): Resource<SportsCategoryDTO>
}