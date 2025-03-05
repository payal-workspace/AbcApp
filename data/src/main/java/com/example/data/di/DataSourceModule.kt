package com.example.data.di

import com.example.data.dataSource.SportsDataSource
import com.example.data.dataSource.SportsTable
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Singleton
    @Provides
    fun provideDataSource(): SportsDataSource = SportsTable()
}