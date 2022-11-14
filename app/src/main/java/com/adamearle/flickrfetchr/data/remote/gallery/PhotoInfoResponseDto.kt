package com.adamearle.flickrfetchr.data.remote.gallery

import com.squareup.moshi.Json

data class PhotoInfoResponseDto(
    @field:Json(name = "photo")
    val photoInfoDto: PhotoInfoDto,
    @field:Json(name = "stat")
    val stat: String
)
