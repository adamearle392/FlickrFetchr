package com.adamearle.flickrfetchr.domain.repository

import com.adamearle.flickrfetchr.domain.photo.Gallery
import com.adamearle.flickrfetchr.domain.photo.PhotoInfo
import com.adamearle.flickrfetchr.domain.util.Resource

interface PhotoRepository {
    suspend fun getGallery(): Resource<Gallery>
    suspend fun getPhotoInfo(photo_id: String): Resource<PhotoInfo>
    suspend fun getPhotosByTag(tag: String): Resource<Gallery>
}