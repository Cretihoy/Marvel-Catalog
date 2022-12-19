package me.cretihoy.service.data.service

import me.cretihoy.model.data.model.CharacterDataWrapper
import me.cretihoy.model.data.model.ComicDataWrapper
import me.cretihoy.model.data.model.ComicDateDescriptor
import me.cretihoy.model.data.model.ComicFormat
import me.cretihoy.model.data.model.ComicFormatType
import me.cretihoy.model.data.model.ComicOrder
import me.cretihoy.model.data.model.CreatorDataWrapper
import me.cretihoy.model.data.model.EventDataWrapper
import me.cretihoy.model.data.model.SeriesDataWrapper
import me.cretihoy.model.data.model.StoryDataWrapper
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.Date

interface ComicService {

    @GET("/v1/public/comics/{comicId}/creators")
    suspend fun getCreatorsByComicId(
        @Path("comicId") comicId: Int
    ): CreatorDataWrapper

    @GET("/v1/public/comics/{comicId}/events")
    suspend fun getEventsByComicId(
        @Path("comicId") comicId: Int
    ): EventDataWrapper

    @GET("/v1/public/comics/{comicId}/series")
    suspend fun getSeriesByComicId(
        @Path("comicId") comicId: Int
    ): SeriesDataWrapper

    @GET("/v1/public/comics/{comicId}/stories")
    suspend fun getStoriesByComicId(
        @Path("comicId") comicId: Int
    ): StoryDataWrapper

    @GET("/v1/public/comics/{comicId}/characters")
    suspend fun getCharactersByComicId(
        @Path("comicId") comicId: Int
    ): CharacterDataWrapper

    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("format") format: ComicFormat? = null,
        @Query("formatType") formatType: ComicFormatType? = null,
        @Query("noVariants") noVariants: Boolean? = null,
        @Query("dateDescriptor") dateDescriptor: ComicDateDescriptor? = null,
        @Query("dateRange") dateRange: Int? = null,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("issueNumber") issueNumber: Int? = null,
        @Query("diamondCode") diamondCode: String? = null,
        @Query("digitalId") digitalId: Int? = null,
        @Query("upc") upc: String? = null,
        @Query("isbn") isbn: String? = null,
        @Query("ean") ean: String? = null,
        @Query("issn") issn: String? = null,
        @Query("hasDigitalIssue") hasDigitalIssue: Boolean? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: Int? = null,
        @Query("characters") characters: Int? = null,
        @Query("series") series: Int? = null,
        @Query("events") events: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("sharedAppearances") sharedAppearances: Int? = null,
        @Query("collaborators") collaborators: Int? = null,
        @Query("orderBy") orderBy: ComicOrder? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): ComicDataWrapper
}