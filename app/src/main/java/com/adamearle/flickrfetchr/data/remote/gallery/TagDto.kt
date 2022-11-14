package com.adamearle.flickrfetchr.data.remote.gallery

import com.squareup.moshi.Json

data class TagDto(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "author")
    val author: String,
    @field:Json(name = "authorname")
    val authorname: String,
    @field:Json(name = "raw")
    val raw: String,
    @field:Json(name = "_content")
    val _content: String,
    @field:Json(name = "machine_tag")
    val machine_tag: Int
)
