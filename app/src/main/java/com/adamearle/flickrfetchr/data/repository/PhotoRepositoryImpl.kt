package com.adamearle.flickrfetchr.data.repository

import com.adamearle.flickrfetchr.data.mappers.toGallery
import com.adamearle.flickrfetchr.data.mappers.toPhotoInfo
import com.adamearle.flickrfetchr.data.remote.FlickrApi
import com.adamearle.flickrfetchr.domain.photo.Gallery
import com.adamearle.flickrfetchr.domain.photo.PhotoInfo
import com.adamearle.flickrfetchr.domain.repository.PhotoRepository
import com.adamearle.flickrfetchr.domain.util.Resource
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val api: FlickrApi
) : PhotoRepository {
    override suspend fun getGallery(): Resource<Gallery> {
        return try {
            Resource.Success(
                data = api.getGalleryPhotos().toGallery()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

    override suspend fun getPhotoInfo(photo_id: String): Resource<PhotoInfo> {
        return try {
            Resource.Success(
                data = api.getPhotoInfo(photo_id = photo_id).toPhotoInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

    override suspend fun getPhotosByTag(tag: String): Resource<Gallery> {
        return try {
            Resource.Success(
                data = api.getPhotosByTag(tag = tag).toGallery()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}