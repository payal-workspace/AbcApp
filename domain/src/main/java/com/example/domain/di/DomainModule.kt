package com.example.domain.di

import com.example.domain.mapper.CategoriesDomainDataMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideCategoriesDomainDataMapper(): CategoriesDomainDataMapper {
        return CategoriesDomainDataMapper()
    }
}