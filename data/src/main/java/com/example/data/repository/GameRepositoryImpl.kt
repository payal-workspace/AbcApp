package com.example.data.repository

import com.example.domain.utils.Resource
import com.example.data.dataSource.SportsDataSource
import com.example.data.mapper.SportsCategoryDataMapper
import com.example.domain.dto.SportsCategoryDTO
import com.example.domain.repository.SportsRepository
import java.io.IOException
import javax.inject.Inject

class SportsRepositoryImpl @Inject constructor(
    private val sportsDataSource: SportsDataSource,
    private val sportsCategoryDataMapper: SportsCategoryDataMapper
) : SportsRepository {

    override suspend fun getSportsCategories(): Resource<SportsCategoryDTO> {
        return try {
            val response = sportsDataSource.fetchSportsCategories()
            val domainDTO = sportsCategoryDataMapper.mapDataToDto(response)

            Resource.Success(domainDTO)
        } catch (e: IOException) {
            Resource.Failure(e)
        }
    }
}
