package com.adamearle.flickrfetchr.data.remote.gallery

import com.squareup.moshi.Json

data class GalleryDto(
    @field:Json(name = "page")
    val page: Int,
    @field:Json(name = "pages")
    val pages: Int,
    @field:Json(name = "perpage")
    val perPage: Int,
    @field:Json(name = "total")
    val total: Int,
    @field:Json(name = "photo")
    val photoDtoList: List<PhotoDto>
)