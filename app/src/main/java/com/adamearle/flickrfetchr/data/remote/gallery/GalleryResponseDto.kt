package com.adamearle.flickrfetchr.data.remote.gallery

import com.squareup.moshi.Json

data class GalleryResponseDto(
    @field:Json(name = "photos")
    val galleryDto: GalleryDto,
    @field:Json(name = "stat")
    val stat: String
)