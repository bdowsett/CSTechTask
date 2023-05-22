package com.example.cstechtask.di

import com.example.cstechtask.common.Constants
import com.example.cstechtask.data.DonutApi
import com.example.cstechtask.data.repository.DonutRepositoryImpl
import com.example.cstechtask.domain.repository.DonutRepository
import com.example.cstechtask.domain.use_case.GetDonutDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDonutApi(): DonutApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            MoshiConverterFactory.create(),
        ).build().create(DonutApi::class.java)
    }

    @Provides
    @Singleton
    fun providesDonutRepo(api: DonutApi): DonutRepository {
        return DonutRepositoryImpl(api)
    }
}

