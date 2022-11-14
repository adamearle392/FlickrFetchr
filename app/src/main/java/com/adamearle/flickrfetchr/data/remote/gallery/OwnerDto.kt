package com.adamearle.flickrfetchr.data.remote.gallery

import com.squareup.moshi.Json

data class OwnerDto(
    @field:Json(name = "nsid")
    val nsid: String,
    @field:Json(name = "username")
    val username: String,
    @field:Json(name = "realname")
    val realname: String,
    @field:Json(name = "location")
    val location: String,
    @field:Json(name = "iconserver")
    val iconserver: String,
    @field:Json(name = "iconfarm")
    val iconfarm: Int,
)
