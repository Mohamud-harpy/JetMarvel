package com.example.jetpackcomposemarvel.presentation.characterdetailes

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposemarvel.common.Constants
import com.example.jetpackcomposemarvel.common.Resource
import com.example.jetpackcomposemarvel.di.AppModule
import com.example.jetpackcomposemarvel.domain.usecase.getcharacterdetails.CharacterDetailsUsecase
import com.example.jetpackcomposemarvel.domain.usecase.getmarvelcharacter.MarvelCharacterUsecase
import com.example.jetpackcomposemarvel.presentation.characterdetailes.components.CharacterDetailsState
import com.example.jetpackcomposemarvel.presentation.marvelcharacter.components.MarvelCharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
     savedStateHandle : SavedStateHandle,
    private val characterDetailsUsecase: CharacterDetailsUsecase):ViewModel(){
      private  val _state = mutableStateOf(CharacterDetailsState())
        val state :State<CharacterDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_CHARACTER_ID)?.let {characterId ->

            getCharacterDetails(characterId, AppModule.getmap())
            Log.d("Characterid ", "character id is /n $characterId")
        }
    }
    private fun getCharacterDetails(characterId :String , map : Map<String,String>){
        characterDetailsUsecase(characterId ,map).onEach { result ->
            Log.d("Characterid ", "character result  is /n ${result.data}")
            Log.d("Characterid ", "Detailslist Code is \n ${result.data?.code}")

            when(result){

                is Resource.Success -> {
                    _state.value = CharacterDetailsState(detailsList = result.data!!.data.results )

                    Log.d("Characterid ", "Detailslist id is \n ${_state.value}")


                }
                is Resource.Error -> {
                    _state.value = CharacterDetailsState(error = result.message?:" an unxpected error occure")

                    Log.d("Characterid ", "Detailslist id is \n ${_state.value}")

                }
                is Resource.Loading -> {
                    _state.value = CharacterDetailsState(isLoading = true)

                }

            }
        }.launchIn(viewModelScope)
    }
}
