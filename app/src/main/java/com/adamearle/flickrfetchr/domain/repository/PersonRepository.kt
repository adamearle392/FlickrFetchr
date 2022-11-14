package com.adamearle.flickrfetchr.domain.repository

import com.adamearle.flickrfetchr.domain.person.Person
import com.adamearle.flickrfetchr.domain.util.Resource

interface PersonRepository {
    suspend fun getOwnerInfo(user_id: String): Resource<Person>
}