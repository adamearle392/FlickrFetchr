package com.adamearle.flickrfetchr.domain.photo

data class Tag(
    val id: String,
    val author: String,
    val authorname: String,
    val raw: String,
    val _content: String,
    val machine_tag: Int
)
