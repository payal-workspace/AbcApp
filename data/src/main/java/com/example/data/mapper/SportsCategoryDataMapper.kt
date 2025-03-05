package com.example.data.mapper

import com.example.data.model.SportsCategoryEntity
import com.example.domain.dto.SportsCategoryDTO
import com.example.domain.dto.SportsCategoryDataDTO
import com.example.domain.dto.SportsCategoryListsDTO
import javax.inject.Inject

class SportsCategoryDataMapper @Inject constructor() {
    fun mapDataToDto(entity: SportsCategoryEntity): SportsCategoryDTO {
        return SportsCategoryDTO(
            data = entity.data.map {
                SportsCategoryDataDTO(
                    sportsCategoryTitle = it.sportsCategoryTitle,
                    sportsCategoryImageUrl = it.sportsCategoryImageUrl,
                    sportsCategoryItem = it.sportsCategoryItem?.map {
                        SportsCategoryListsDTO(
                            sportsTitle = it.sportsTitle,
                            sportsDescription = it.sportsDescription,
                            sportsImageUrl = it.sportsImageUrl
                        )
                    }
                )
            }
        )
    }
}
