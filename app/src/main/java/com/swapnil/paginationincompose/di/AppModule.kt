package com.swapnil.paginationincompose.di

import com.google.gson.Gson
import com.swapnil.paginationincompose.data.remote.ApiService
import com.swapnil.paginationincompose.data.repository.CharacterRepositoryImpl
import com.swapnil.paginationincompose.domain.repostiory.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApi(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideCharacterRepository(api: ApiService): CharacterRepository =
        CharacterRepositoryImpl(api)
}