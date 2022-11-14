package com.adamearle.flickrfetchr.domain.photo

data class PhotoInfo(
    val id: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val dateuploaded: String,
    val owner: Owner?,
    val tagList: List<Tag>
)