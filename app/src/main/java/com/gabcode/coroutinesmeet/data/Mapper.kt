package com.gabcode.coroutinesmeet.data

import com.gabcode.coroutinesmeet.data.local.Item
import com.gabcode.coroutinesmeet.data.local.Paging
import com.gabcode.coroutinesmeet.data.local.Picture
import com.gabcode.coroutinesmeet.data.local.SearchResult
import com.gabcode.coroutinesmeet.data.remote.model.ItemDto
import com.gabcode.coroutinesmeet.data.remote.model.PagingDto
import com.gabcode.coroutinesmeet.data.remote.model.PictureDto
import com.gabcode.coroutinesmeet.data.remote.model.SearchResultDto
import com.gabcode.coroutinesmeet.extension.empty

fun ItemDto.mapToModel(): Item {
    return Item(
        this.id,
        this.title,
        this.price,
        this.currency,
        this.thumbnail,
        this.availableQuantity,
        this.condition,
        mapPictureListToDomain(this.pictures))
}

private fun mapPictureListToDomain(pictureDto: List<PictureDto>): List<Picture> {
    return when (pictureDto.isNullOrEmpty()) {
        true -> emptyList()
        else -> {
            pictureDto.map { Picture(it.id, it.url) }
        }
    }
}


fun List<ItemDto>.mapToModel(): List<Item> {
    return this.map { it.mapToModel() }
}

fun SearchResultDto<ItemDto>.mapToModel(): SearchResult<Item> {
    val paging = this.pagingDto?.mapToModel() ?: Paging.empty()
    val results: List<ItemDto> = this.results
    return SearchResult(paging, this.query ?: String.empty(), results.mapToModel())
}

private fun PagingDto.mapToModel(): Paging {
    return Paging(this.total, this.offset, this.limit)
}