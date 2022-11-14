package com.adamearle.flickrfetchr.domain.photo

import com.adamearle.flickrfetchr.domain.person.Person

data class Photo(
    val id: String,
    val owner: String,
    val title: String,
    val server: String,
    val secret: String,
    var person: Person? = null,
)