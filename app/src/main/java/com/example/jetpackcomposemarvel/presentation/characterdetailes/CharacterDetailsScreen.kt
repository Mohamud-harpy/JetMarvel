package com.example.jetpackcomposemarvel.presentation.characterdetailes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackcomposemarvel.data.remote.dto.Result
import com.example.jetpackcomposemarvel.presentation.Screen
import com.example.jetpackcomposemarvel.presentation.characterdetailes.components.CharacterDetailsListItems
import com.example.jetpackcomposemarvel.presentation.marvelcharacter.components.MarvelCharacterListItems

@Composable
fun CharacterDetailsScreen(
    navController: NavController,
    viewModel: CharacterDetailsViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize().background(Color.LightGray)) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(5.dp)
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize().background(Color.LightGray)) {
                items(state.detailsList){ marvel ->
                    CharacterDetailsListItems(result = marvel )

                }

            }

        }


        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}