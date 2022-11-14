package com.adamearle.flickrfetchr.data.remote.gallery

import com.squareup.moshi.Json

data class PhotoInfoDto(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "secret")
    val secret: String,
    @field:Json(name = "server")
    val server: String,
    @field:Json(name = "farm")
    val farm: Int,
    @field:Json(name = "dateuploaded")
    val dateuploaded: String,
    @field:Json(name = "owner")
    val ownerDto: OwnerDto,
    @field:Json(name = "tags")
    val tags: TagsDto
)
