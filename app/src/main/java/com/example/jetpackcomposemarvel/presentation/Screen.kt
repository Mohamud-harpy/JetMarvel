package com.example.jetpackcomposemarvel.presentation

sealed class Screen(val route: String) {
    object MarvelCharacterScreen: Screen("Marvel_Character_Screen")
    object CharacterDetailsScreen: Screen("Character_Details_Screen")
}

