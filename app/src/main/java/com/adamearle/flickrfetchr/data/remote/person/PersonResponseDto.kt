package com.adamearle.flickrfetchr.data.remote.person

import com.squareup.moshi.Json

data class PersonResponseDto(
    @field:Json(name = "person")
    val personDto: PersonDto,
    @field:Json(name = "stat")
    val stat: String
)
