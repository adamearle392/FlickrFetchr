package com.adamearle.flickrfetchr.data.mappers

import com.adamearle.flickrfetchr.data.remote.gallery.PhotoInfoResponseDto
import com.adamearle.flickrfetchr.data.remote.gallery.TagDto
import com.adamearle.flickrfetchr.domain.photo.Owner
import com.adamearle.flickrfetchr.domain.photo.PhotoInfo
import com.adamearle.flickrfetchr.domain.photo.Tag

fun PhotoInfoResponseDto.toPhotoInfo(): PhotoInfo {
    val tagList: MutableList<Tag> = mutableListOf()

    for (tagDto: TagDto in photoInfoDto.tags.tagList) {
        tagList.add(
            Tag(
                id = tagDto.id,
                author = tagDto.author,
                authorname = tagDto.authorname,
                raw = tagDto.raw,
                _content = tagDto._content,
                machine_tag = tagDto.machine_tag,
            )
        )
    }

    val owner = Owner(
        nsid = photoInfoDto.ownerDto.nsid,
        username = photoInfoDto.ownerDto.username,
        realname = photoInfoDto.ownerDto.realname,
        location = photoInfoDto.ownerDto.location,
        iconserver = photoInfoDto.ownerDto.iconserver,
        iconfarm = photoInfoDto.ownerDto.iconfarm,
    )

    return PhotoInfo(
        id = photoInfoDto.id,
        secret = photoInfoDto.secret,
        server = photoInfoDto.server,
        farm = photoInfoDto.farm,
        dateuploaded = photoInfoDto.dateuploaded,
        owner = owner,
        tagList = tagList,
    )
}