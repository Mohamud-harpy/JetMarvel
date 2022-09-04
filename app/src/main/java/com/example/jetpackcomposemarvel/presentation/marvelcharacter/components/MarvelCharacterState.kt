package com.example.jetpackcomposemarvel.presentation.marvelcharacter.components

import com.example.jetpackcomposemarvel.data.remote.dto.Result

data class MarvelCharacterState(
    val isLoading :Boolean= false,
    val marvelList :List<Result> = emptyList(),
    val error :String = ""
)
