package com.adamearle.flickrfetchr.domain.photo

data class Gallery(
    var page: Int,
    var pages: Int,
    var perPage: Int,
    var total: Int,
    var photos: List<Photo>?
)
