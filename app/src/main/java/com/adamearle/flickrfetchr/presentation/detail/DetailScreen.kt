package com.adamearle.flickrfetchr.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.adamearle.flickrfetchr.presentation.util.Screen

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    photo_id: String,
    navigateToTagScreen: (tag: String) -> Unit
) {
    val tag = Screen.Detail.route

    viewModel.loadPhotoInfo(photo_id)

    if (viewModel.state.photoInfo != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
        ) {
            Text(
                text = "ID: ${viewModel.state.photoInfo!!.id}",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(0.dp, 16.dp, 0.dp, 0.dp),
                style = MaterialTheme.typography.h5
            )
            Card(
                backgroundColor = Color.LightGray,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.padding(16.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    item {
                        AsyncImage(
                            model = "https://live.staticflickr.com/${viewModel.state.photoInfo!!.server}/${viewModel.state.photoInfo!!.id}_${viewModel.state.photoInfo!!.secret}.jpg",
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .fillMaxSize()
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "Secret: ${viewModel.state.photoInfo!!.secret}")
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "Server: ${viewModel.state.photoInfo!!.server}")
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "Farm: ${viewModel.state.photoInfo!!.farm}")
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "Date Uploaded: ${viewModel.state.photoInfo!!.dateuploaded}")
                        Spacer(modifier = Modifier.height(16.dp))
                        if (viewModel.state.photoInfo!!.owner != null) {
                            Text(text = "Owner NSID: ${viewModel.state.photoInfo!!.owner!!.nsid}")
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(text = "Owner Username: ${viewModel.state.photoInfo!!.owner!!.username}")
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(text = "Owner Real Name: ${viewModel.state.photoInfo!!.owner!!.realname}")
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(text = "Owner Location: ${viewModel.state.photoInfo!!.owner!!.location}")
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(text = "Owner Icon Server: ${viewModel.state.photoInfo!!.owner!!.iconserver}")
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(text = "Owner Icon Farm: ${viewModel.state.photoInfo!!.owner!!.iconfarm}")
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                        AsyncImage(
                            model = "http://farm${viewModel.state.photoInfo!!.owner!!.iconfarm}.staticflickr.com/${viewModel.state.photoInfo!!.owner!!.iconserver}/buddyicons/${viewModel.state.photoInfo!!.owner!!.nsid}.jpg",
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .fillMaxSize()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        viewModel.state.photoInfo!!.tagList.forEach { tag ->
                            Text(text = "Tag: ${tag.raw}", modifier = Modifier.pointerInput(Unit) {
                                detectTapGestures(
                                    onTap = { navigateToTagScreen(tag.raw) }
                                )
                            })
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}

