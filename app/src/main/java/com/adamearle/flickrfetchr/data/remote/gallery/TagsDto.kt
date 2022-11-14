package com.adamearle.flickrfetchr.data.remote.gallery

import com.squareup.moshi.Json

data class TagsDto(
    @field:Json(name = "tag")
    val tagList: List<TagDto>
)
