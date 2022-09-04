package com.example.jetpackcomposemarvel.presentation.marvelcharacter

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposemarvel.common.Resource
import com.example.jetpackcomposemarvel.di.AppModule
import com.example.jetpackcomposemarvel.domain.usecase.getmarvelcharacter.MarvelCharacterUsecase
import com.example.jetpackcomposemarvel.presentation.marvelcharacter.components.MarvelCharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MarvelCharacterViewModel @Inject constructor(
    private val marvelCharacterUsecase: MarvelCharacterUsecase):ViewModel(){
      private  val _state = mutableStateOf(MarvelCharacterState())
        val state :State<MarvelCharacterState> = _state

    init {
        getMarvelCharacter()
    }
    private fun getMarvelCharacter(){
        marvelCharacterUsecase(AppModule.getmap()).onEach { result ->
            Log.d("Characterid ", "marvel result  is /n ${result.data}")

            when(result){

                is Resource.Success -> {
                    _state.value = MarvelCharacterState(marvelList = result.data!!.data.results )


                }
                is Resource.Error -> {
                    _state.value = MarvelCharacterState(error = result.message?:" an unxpected error occure")


                }
                is Resource.Loading -> {
                    _state.value = MarvelCharacterState(isLoading = true)

                }

            }
        }.launchIn(viewModelScope)
    }
}
