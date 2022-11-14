package com.adamearle.flickrfetchr.data.mappers

import com.adamearle.flickrfetchr.data.remote.gallery.GalleryDto
import com.adamearle.flickrfetchr.data.remote.gallery.GalleryResponseDto
import com.adamearle.flickrfetchr.data.remote.gallery.PhotoDto
import com.adamearle.flickrfetchr.domain.photo.Gallery
import com.adamearle.flickrfetchr.domain.photo.Photo

fun GalleryResponseDto.toGallery(): Gallery {
    return Gallery(
        page = galleryDto.page,
        pages = galleryDto.pages,
        perPage = galleryDto.perPage,
        total = galleryDto.total,
        photos = galleryDto.toPhotoList()
    )
}

fun GalleryDto.toPhotoList(): List<Photo> {
    val photoList: MutableList<Photo> = mutableListOf()

    for (photoDto in photoDtoList) {
        photoList.add(photoDto.toPhoto())
    }

    return photoList
}

fun PhotoDto.toPhoto(): Photo {
    return Photo(
        id = id,
        owner = owner,
        title = title,
        server = server,
        secret = secret
    )
}