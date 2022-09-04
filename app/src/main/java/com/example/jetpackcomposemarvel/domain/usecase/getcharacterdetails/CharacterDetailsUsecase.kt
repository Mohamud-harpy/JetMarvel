package com.example.jetpackcomposemarvel.domain.usecase.getcharacterdetails

import com.example.jetpackcomposemarvel.common.Resource
import com.example.jetpackcomposemarvel.data.remote.dto.MarvelCharacterDto
import com.example.jetpackcomposemarvel.domain.repository.MarvelCharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class CharacterDetailsUsecase @Inject constructor(private val repository: MarvelCharacterRepository) {
    operator fun invoke (characterId : String,map: Map<String,String>):Flow<Resource<MarvelCharacterDto>> = flow {

        try {
            emit(Resource.Loading())
            val CharacterDetails = repository.getCharacterDetails(characterId , map)
            emit(Resource.Success(CharacterDetails))
        }catch (e : HttpException){
                 emit(Resource.Error(e.localizedMessage?: "an unxpected Error Mohamed"))
        }catch (e : IOException){
            emit(Resource.Error("there is error in connection mohamed "))
        }

    }

}