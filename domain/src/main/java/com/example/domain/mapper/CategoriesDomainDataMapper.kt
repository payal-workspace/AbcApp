package com.example.domain.mapper

import com.example.domain.dto.SportsCategoryDTO
import com.example.domain.dto.SportsCategoryDataDTO
import com.example.domain.dto.SportsCategoryListsDTO
import com.example.domain.model.SportsModel
import com.example.domain.model.SportsModelData
import com.example.domain.model.SportsModelLists
import javax.inject.Inject

class CategoriesDomainDataMapper @Inject constructor() : DataToDomainModelMapper {
    override fun mapToDomainModel(responseModel: SportsCategoryDTO?): SportsModel {
        val detailResponse = requireNotNull(responseModel)
        return SportsModel(
            data = dataToDomainModel(detailResponse.data)
        )
    }

    private fun dataToDomainModel(sportsTitle: List<SportsCategoryDataDTO>?): List<SportsModelData> {
        return sportsTitle?.map {
            SportsModelData(
                sportsCategoryTitle = it.sportsCategoryTitle,
                sportsCategoryImageUrl = it.sportsCategoryImageUrl,
                sportsCategoryItem = dataToDomainModelItem(it.sportsCategoryItem)
            )
        } ?: emptyList()
    }

    private fun dataToDomainModelItem(sportsTitle: List<SportsCategoryListsDTO>?): List<SportsModelLists>? {
        return sportsTitle?.map {
            SportsModelLists(
                sportsImageUrl = it.sportsImageUrl,
                sportsTitle = it.sportsTitle,
                sportsDescription = it.sportsDescription
            )
        } ?: emptyList()
    }
}


