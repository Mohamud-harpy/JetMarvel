package com.example.jetpackcomposemarvel.domain.repository

import com.example.jetpackcomposemarvel.data.remote.dto.MarvelCharacterDto


interface MarvelCharacterRepository {

    suspend fun getMarvelCharacter( map: Map<String,String>
    ): MarvelCharacterDto


    suspend fun getCharacterDetails( characterId : String, map: Map<String,String>
    ): MarvelCharacterDto
}