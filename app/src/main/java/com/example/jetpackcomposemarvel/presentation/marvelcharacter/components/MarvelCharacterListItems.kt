package com.example.jetpackcomposemarvel.presentation.marvelcharacter.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackcomposemarvel.data.remote.dto.Result

@Composable
fun MarvelCharacterListItems (result: Result , onItemClick : (Result) -> Unit) {
    val path:String =result.thumbnail.path
    val extension:String= result.thumbnail.extension
    val dot ="."
    val thumbnail = "$path$dot$extension"

    Card(modifier = Modifier
        .background(Color.Transparent)
        .fillMaxWidth().clip(shape = RoundedCornerShape(30.dp))) {


        Row(modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(5.dp)
            .clickable { onItemClick(result) }) {
            Image(
                painter = rememberAsyncImagePainter(thumbnail),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(10.dp))

            Text(text = result.name,
            textAlign = TextAlign.Center,
            )


        }


    }
    Spacer(modifier = Modifier.padding(5.dp))
}