package com.example.domain.di

import com.example.domain.mapper.CategoriesDomainDataMapper
import com.example.domain.repository.SportsRepository
import com.example.domain.usecase.GetSportsCategoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideHomeUseCase(
        sportsRepository: SportsRepository,
        categoriesToDomainDataMapper: CategoriesDomainDataMapper,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ) = GetSportsCategoriesUseCase(
        sportsRepository,
        categoriesToDomainDataMapper,
        dispatcher
    )
}