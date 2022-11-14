package com.adamearle.flickrfetchr.data.mappers

import com.adamearle.flickrfetchr.data.remote.person.PersonDto
import com.adamearle.flickrfetchr.data.remote.person.PersonResponseDto
import com.adamearle.flickrfetchr.domain.person.Person

fun PersonResponseDto.toPerson(): Person {
    return Person(
        id = personDto.id,
        nsid = personDto.nsid,
        iconserver = personDto.iconserver,
        iconfarm = personDto.iconfarm
    )
}