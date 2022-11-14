package com.adamearle.flickrfetchr.data.remote

import com.adamearle.flickrfetchr.data.remote.gallery.GalleryResponseDto
import com.adamearle.flickrfetchr.data.remote.gallery.PhotoInfoResponseDto
import com.adamearle.flickrfetchr.data.remote.person.PersonResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
    companion object {
        const val API_KEY = "bac6691f41e4a82608ae1c897625b9c9"
        const val GALLERY_ID = "72157721242723696"
    }

    @GET("?method=flickr.galleries.getPhotos")
    suspend fun getGalleryPhotos(
        @Query("format") format: String = "json",
        @Query("nojsoncallback") nojsoncallback: Int = 1,
        @Query("api_key") api_key: String = API_KEY,
        @Query("gallery_id") gallery_id: String = GALLERY_ID
    ): GalleryResponseDto

    @GET("?method=flickr.people.getInfo")
    suspend fun getOwnerInfo(
        @Query("format") format: String = "json",
        @Query("nojsoncallback") nojsoncallback: Int = 1,
        @Query("api_key") api_key: String = API_KEY,
        @Query("user_id") user_id: String
    ): PersonResponseDto

    @GET("?method=flickr.photos.getInfo")
    suspend fun getPhotoInfo(
        @Query("format") format: String = "json",
        @Query("nojsoncallback") nojsoncallback: Int = 1,
        @Query("api_key") api_key: String = API_KEY,
        @Query("photo_id") photo_id: String
    ): PhotoInfoResponseDto

    @GET("?method=flickr.photos.search")
    suspend fun getPhotosByTag(
        @Query("format") format: String = "json",
        @Query("nojsoncallback") nojsoncallback: Int = 1,
        @Query("per_page") per_page: Int = 10,
        @Query("safe_search") safe_search: Int = 1,
        @Query("api_key") api_key: String = API_KEY,
        @Query("tags") tag: String
    ): GalleryResponseDto
}