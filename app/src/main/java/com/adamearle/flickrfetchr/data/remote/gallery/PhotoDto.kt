package com.adamearle.flickrfetchr.data.remote.gallery

import com.squareup.moshi.Json

data class PhotoDto(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "owner")
    val owner: String,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "server")
    val server: String,
    @field:Json(name = "secret")
    val secret: String
)
