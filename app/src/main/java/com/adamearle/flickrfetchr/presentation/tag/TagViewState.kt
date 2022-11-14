package com.adamearle.flickrfetchr.presentation.tag

import com.adamearle.flickrfetchr.domain.photo.Gallery

data class TagViewState(
    val gallery: Gallery? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
