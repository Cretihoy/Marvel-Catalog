package me.cretihoy.service.data.service

import me.cretihoy.model.data.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface CreatorService {

    @GET("/v1/public/creators/{creatorId}/comics")
    suspend fun getComicsByCreatorId(
        @Path("creatorId") creatorId: Int
    ): ComicDataWrapper

    @GET("/v1/public/creators/{creatorId}/stories")
    suspend fun getStoriesByCreatorId(
        @Path("creatorId") creatorId: Int
    ): StoryDataWrapper

    @GET("/v1/public/creators/{creatorId}/events")
    suspend fun getEventsByCreatorId(
        @Path("creatorId") creatorId: Int
    ): EventDataWrapper

    @GET("/v1/public/creators/{creatorId}/series")
    suspend fun getSeriesByCreatorId(
        @Path("creatorId") creatorId: Int
    ): SeriesDataWrapper

    @GET("/v1/public/creators")
    suspend fun getCreators(
        @Query("firstName") firstName: String? = null,
        @Query("middleName") middleName: String? = null,
        @Query("lastName") lastName: String? = null,
        @Query("suffix") suffix: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("firstNameStartsWith") firstNameStartsWith: String? = null,
        @Query("middleNameStartsWith") middleNameStartsWith: String? = null,
        @Query("lastNameStartsWith") lastNameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: Int? = null,
        @Query("series") series: Int? = null,
        @Query("events") events: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("orderBy") orderBy: CreatorOrder? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): CreatorDataWrapper
}