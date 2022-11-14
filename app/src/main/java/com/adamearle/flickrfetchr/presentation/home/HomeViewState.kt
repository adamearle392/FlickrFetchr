package com.adamearle.flickrfetchr.presentation.home

import com.adamearle.flickrfetchr.domain.person.Person
import com.adamearle.flickrfetchr.domain.photo.Gallery
import com.adamearle.flickrfetchr.domain.photo.Photo
import com.adamearle.flickrfetchr.domain.photo.Tag

data class HomeViewState(
    val gallery: Gallery? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val photoPersonMap: MutableMap<Photo?, Person> = mutableMapOf(),
    val photoTagMap: MutableMap<Photo?, List<Tag>> = mutableMapOf()
)
