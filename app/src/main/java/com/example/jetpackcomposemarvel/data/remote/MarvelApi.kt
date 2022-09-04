package com.example.jetpackcomposemarvel.data.remote

import com.example.jetpackcomposemarvel.data.remote.dto.MarvelCharacterDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MarvelApi {

    @GET("/v1/public/characters")
    suspend fun getMarvelCharacter(@QueryMap map: Map<String,String>
    ): MarvelCharacterDto

    @GET("/v1/public/characters/{characterId}")
    suspend fun getCharacterDetails(@Path("characterId") characterId:String, @QueryMap map: Map<String,String>
    ): MarvelCharacterDto
}