package me.cretihoy.service.data.service

import me.cretihoy.model.data.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface SeriesService {

    @GET("/v1/public/series/{seriesId}/characters")
    suspend fun getCharactersBySeriesId(
        @Path("seriesId") seriesId: Int
    ): CharacterDataWrapper

    @GET("/v1/public/series/{seriesId}/comics")
    suspend fun getComicsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): ComicDataWrapper

    @GET("/v1/public/series/{seriesId}/stories")
    suspend fun getStoriesBySeriesId(
        @Path("seriesId") seriesId: Int
    ): StoryDataWrapper

    @GET("/v1/public/series/{seriesId}/events")
    suspend fun getEventsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): EventDataWrapper

    @GET("/v1/public/series/{seriesId}/creators")
    suspend fun getCreatorsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): CreatorDataWrapper

    @GET("/v1/public/series")
    suspend fun getSeries(
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("events") events: Int? = null,
        @Query("creators") creators: Int? = null,
        @Query("characters") characters: Int? = null,
        @Query("seriesType") seriesType: String? = null,
        @Query("contains") contains: SeriesContains? = null,
        @Query("orderBy") orderBy: SeriesOrder? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): SeriesDataWrapper
}