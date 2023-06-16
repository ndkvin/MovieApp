package com.android.newsapp.di

import com.android.newsapp.data.api.ApiSeriesInterface
import com.android.newsapp.data.repository.SeriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideSeriesRepository(
        apiSeriesInterface: ApiSeriesInterface
    ): SeriesRepository {
        return SeriesRepository(apiSeriesInterface)
    }
}