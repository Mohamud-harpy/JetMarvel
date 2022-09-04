package com.example.jetpackcomposemarvel.data.repository

import com.example.jetpackcomposemarvel.data.remote.MarvelApi
import com.example.jetpackcomposemarvel.data.remote.dto.MarvelCharacterDto
import com.example.jetpackcomposemarvel.domain.repository.MarvelCharacterRepository
import javax.inject.Inject

class MarvelCharacterRepoImp @Inject constructor(private val api :MarvelApi) :MarvelCharacterRepository {
    override suspend fun getMarvelCharacter(map: Map<String, String>): MarvelCharacterDto {
        return api.getMarvelCharacter(map)
    }

    override suspend fun getCharacterDetails(
        characterId: String,
        map: Map<String, String>
    ): MarvelCharacterDto {

        return api.getCharacterDetails(characterId,map)
    }

}