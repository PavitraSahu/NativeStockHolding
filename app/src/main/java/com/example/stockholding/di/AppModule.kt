package com.example.stockholding.di

import com.example.stockholding.api.ApiService
import com.example.stockholding.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getApiService(): ApiService {
        return Retrofit.Builder().baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Provides
    fun getAppRepository(apiService: ApiService):AppRepository{
        return AppRepository(apiService)
    }
}