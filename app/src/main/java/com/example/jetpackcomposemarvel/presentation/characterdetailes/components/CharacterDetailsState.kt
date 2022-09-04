package com.example.jetpackcomposemarvel.presentation.characterdetailes.components

import com.example.jetpackcomposemarvel.data.remote.dto.Result

data class CharacterDetailsState(
    val isLoading:Boolean= false,
    val detailsList:List<Result> = emptyList(),
    val error:String = "",

)
