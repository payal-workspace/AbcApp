package com.example.domain.usecase

import com.example.domain.di.IoDispatcher
import com.example.domain.mapper.DataToDomainModelMapper
import com.example.domain.model.SportsModel
import com.example.domain.repository.SportsRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetSportsCategoriesUseCase @Inject constructor(
    private val getDetailRepository: SportsRepository,
    private val detailMapper: DataToDomainModelMapper,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Flow<Resource<SportsModel?>> = flow {
        try {
            when (val resource = getDetailRepository.getSportsCategories()) {
                is Resource.Success -> {
                    val mappedData = detailMapper.mapToDomainModel(resource.data)
                    emit(Resource.Success(mappedData))
                }

                is Resource.Failure -> {
                    emit(Resource.Failure(resource.error))
                }

                else -> {
                    emit(Resource.Failure(Exception("$resource")))
                }
            }
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }.flowOn(dispatcher)
}
