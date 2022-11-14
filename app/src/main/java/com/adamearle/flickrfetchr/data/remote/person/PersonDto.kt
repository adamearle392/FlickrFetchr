package com.adamearle.flickrfetchr.data.remote.person

import com.squareup.moshi.Json

data class PersonDto(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "nsid")
    val nsid: String,
    @field:Json(name = "iconserver")
    val iconserver: String,
    @field:Json(name = "iconfarm")
    val iconfarm: Int,
)
