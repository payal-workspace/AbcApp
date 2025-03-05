package com.example.data.di

import com.example.data.dataSource.SportsDataSource
import com.example.data.mapper.SportsCategoryDataMapper
import com.example.data.repository.SportsRepositoryImpl
import com.example.domain.repository.SportsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideSportsCategoryDataMapper(): SportsCategoryDataMapper {
        return SportsCategoryDataMapper()
    }

    @Singleton
    @Provides
    fun provideSportsRepository(
        dataSource: SportsDataSource,
        sportsCategoryDataMapper: SportsCategoryDataMapper
    ): SportsRepository = SportsRepositoryImpl(dataSource, sportsCategoryDataMapper)
}