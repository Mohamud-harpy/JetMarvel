package com.example.jetpackcomposemarvel.di

import com.example.jetpackcomposemarvel.common.Constants
import com.example.jetpackcomposemarvel.data.remote.MarvelApi
import com.example.jetpackcomposemarvel.data.repository.MarvelCharacterRepoImp
import com.example.jetpackcomposemarvel.domain.repository.MarvelCharacterRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule  {
    @Provides
    @Singleton
    fun provideMarvelApi(): MarvelApi {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return   Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(MarvelApi::class.java)
    }

    @Provides
    @Singleton
    fun getmap(): Map<String,String> {
        return mapOf(
            Pair("apikey",Constants.PUBLIC_KEY),
            Pair("ts", Constants.getTimeStamp()),
            Pair("hash",Constants.getMD5()))
    }
    @Provides
    @Singleton
    fun provideMarvelCharacterRepository (api:MarvelApi ) :MarvelCharacterRepository{
        return MarvelCharacterRepoImp(api)
    }
}