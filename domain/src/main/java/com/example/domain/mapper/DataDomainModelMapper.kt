package com.example.domain.mapper

import com.example.domain.dto.SportsCategoryDTO
import com.example.domain.model.SportsModel

interface DataToDomainModelMapper {
    fun mapToDomainModel(responseModel: SportsCategoryDTO?): SportsModel?
}