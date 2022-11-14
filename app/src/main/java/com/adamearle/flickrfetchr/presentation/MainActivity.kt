package com.adamearle.flickrfetchr.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.adamearle.flickrfetchr.presentation.home.HomeViewModel
import com.adamearle.flickrfetchr.presentation.theme.FlickrFetchrTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadGallery()
        setContent {
            FlickrFetchrTheme {
                NavGraph()
            }
        }
    }
}