package com.av.vocabularyquiz.di

import com.av.vocabularyquiz.data.QuizRepositoryImpl
import com.av.vocabularyquiz.data.remote.ApiService
import com.av.vocabularyquiz.domain.repository.QuizRepository
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

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideQuizRepository(apiService: ApiService): QuizRepository {
        return QuizRepositoryImpl(apiService)
    }
}