package com.adamearle.flickrfetchr.di

import com.adamearle.flickrfetchr.data.repository.PersonRepositoryImpl
import com.adamearle.flickrfetchr.data.repository.PhotoRepositoryImpl
import com.adamearle.flickrfetchr.domain.repository.PersonRepository
import com.adamearle.flickrfetchr.domain.repository.PhotoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPhotoRepository(
        photoRepositoryImpl: PhotoRepositoryImpl
    ): PhotoRepository

    @Binds
    @Singleton
    abstract fun bindPersonRepository(
        personRepositoryImpl: PersonRepositoryImpl
    ): PersonRepository
}