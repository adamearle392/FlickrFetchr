package com.adamearle.flickrfetchr.data.repository

import com.adamearle.flickrfetchr.data.mappers.toPerson
import com.adamearle.flickrfetchr.data.remote.FlickrApi
import com.adamearle.flickrfetchr.domain.person.Person
import com.adamearle.flickrfetchr.domain.repository.PersonRepository
import com.adamearle.flickrfetchr.domain.util.Resource
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(
    private val api: FlickrApi
) : PersonRepository {
    override suspend fun getOwnerInfo(user_id: String): Resource<Person> {
        return try {
            Resource.Success(
                data = api.getOwnerInfo(user_id = user_id).toPerson()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}