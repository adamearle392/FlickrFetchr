package com.adamearle.flickrfetchr.domain.photo

data class Owner(
    val nsid: String,
    val username: String,
    val realname: String,
    val location: String,
    val iconserver: String,
    val iconfarm: Int,
)
