package com.adamearle.flickrfetchr.presentation.tag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.adamearle.flickrfetchr.presentation.util.PhotoCard
import com.adamearle.flickrfetchr.presentation.util.Screen

@Composable
fun TagScreen(
    viewModel: TagViewModel = hiltViewModel(),
    tag: String,
) {
    val testTag = Screen.Tag.route

    if (viewModel.state.gallery == null
        || viewModel.state.gallery!!.photos == null
        || viewModel.state.gallery!!.photos!!.isEmpty()
    ) {
        viewModel.getPhotosByTag(tag)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .testTag("${testTag}_Column")
    ) {
        Text(
            text = tag,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(0.dp, 16.dp, 0.dp, 0.dp)
                .testTag("${testTag}_Text_TagTitle"),
            style = MaterialTheme.typography.h5
        )
        if (viewModel.state.gallery != null
            && viewModel.state.gallery!!.photos != null
            && viewModel.state.gallery!!.photos!!.isNotEmpty()
        ) {
            LazyColumn(
                modifier = Modifier
                    .testTag("${testTag}_LazyColumn")
            ) {
                items(viewModel.state.gallery!!.photos!!.size) {
                    val photo = viewModel.state.gallery?.photos?.get(it)
                    PhotoCard(
                        photo = photo
                    )
                }
            }
        }
    }
}