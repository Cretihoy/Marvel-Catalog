package me.cretihoy.service.data.service

import me.cretihoy.model.data.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface EventService {

    @GET("/v1/public/events/{eventId}/creators")
    suspend fun getCreatorsByEventId(
        @Path("eventId") eventId: Int
    ): CreatorDataWrapper

    @GET("/v1/public/events/{eventId}/characters")
    suspend fun getCharactersByEventId(
        @Path("eventId") eventId: Int
    ): CharacterDataWrapper

    @GET("/v1/public/events/{eventId}/comics")
    suspend fun getComicsByEventId(
        @Path("eventId") eventId: Int
    ): ComicDataWrapper

    @GET("/v1/public/events/{eventId}/stories")
    suspend fun getStoriesByEventId(
        @Path("eventId") eventId: Int
    ): StoryDataWrapper

    @GET("/v1/public/events/{eventId}/series")
    suspend fun getSeriesByEventId(
        @Path("eventId") eventId: Int
    ): SeriesDataWrapper

    @GET("/v1/public/events")
    suspend fun getEvents(
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: Int? = null,
        @Query("characters") characters: Int? = null,
        @Query("series") series: Int? = null,
        @Query("events") events: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("orderBy") orderBy: EventsOrder? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): EventDataWrapper
}