package com.adamearle.flickrfetchr.presentation.detail

import com.adamearle.flickrfetchr.domain.photo.PhotoInfo

data class DetailViewState(
    val photoInfo: PhotoInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
