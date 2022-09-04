package com.example.jetpackcomposemarvel.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposemarvel.presentation.characterdetailes.CharacterDetailsScreen
import com.example.jetpackcomposemarvel.presentation.marvelcharacter.MarvelCharacterScreen
import com.example.jetpackcomposemarvel.presentation.theme.JetPackComposeMarvelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeMarvelTheme {
                Navigatpage()
            }
        }
    }
}

@Preview
@Composable
fun Navigatpage(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MarvelCharacterScreen.route,
        builder = {
            composable(route = Screen.MarvelCharacterScreen.route, content = { MarvelCharacterScreen(navController = navController)})
            composable(route = Screen.CharacterDetailsScreen.route+"/{characterId}", content = { CharacterDetailsScreen(
                navController = navController) })


        }
    )
}