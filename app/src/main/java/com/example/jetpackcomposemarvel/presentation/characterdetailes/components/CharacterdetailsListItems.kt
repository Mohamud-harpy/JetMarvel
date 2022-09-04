package com.example.jetpackcomposemarvel.presentation.characterdetailes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackcomposemarvel.data.remote.dto.Result

@Composable
fun CharacterDetailsListItems (result: Result ) {
    val path:String =result.thumbnail.path
    val extension:String= result.thumbnail.extension
    val dot ="."
    val thumbnail = "$path$dot$extension"

    Card(modifier = Modifier
        .background(Color.Transparent)
        .fillMaxSize()
        .clip(shape = RoundedCornerShape(15.dp))) {


        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(5.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(thumbnail),
                contentDescription = null,
                modifier = Modifier
                    .size(350.dp)
                    .align(alignment = CenterHorizontally)

            )
            Spacer(modifier = Modifier.padding(10.dp))

            Text(text ="Name : ${result.name}",
            textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2,


            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Description : \n${result.description}",
                style = MaterialTheme.typography.body2,

            )


        }


    }
    Spacer(modifier = Modifier.padding(5.dp))
}