package com.adamearle.flickrfetchr.presentation.util

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.adamearle.flickrfetchr.domain.photo.Photo

@Composable
fun PhotoCard(
    photo: Photo?,
    modifier: Modifier = Modifier
) {
    Card(
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Title: ${photo?.title}")
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
                model = "https://live.staticflickr.com/${photo?.server}/${photo?.id}_${photo?.secret}.jpg",
                contentDescription = null,
                modifier = modifier.align(CenterHorizontally)
            )
        }
    }
}
