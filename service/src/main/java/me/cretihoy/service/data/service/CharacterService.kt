package me.cretihoy.service.data.service

import me.cretihoy.model.data.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface CharacterService {

    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun getComicsByCharacterId(
        @Path("characterId") characterId: Int,
    ): ComicDataWrapper

    @GET("/v1/public/characters/{characterId}/stories")
    suspend fun getStoriesByCharacterId(
        @Path("characterId") characterId: Int
    ): StoryDataWrapper

    @GET("/v1/public/characters/{characterId}/series")
    suspend fun getSeriesByCharacterId(
        @Path("characterId") characterId: Int
    ): SeriesDataWrapper

    @GET("/v1/public/characters/{characterId}/events")
    suspend fun getEventsByCharacterId(
        @Path("characterId") characterId: Int
    ): EventDataWrapper

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: Int? = null,
        @Query("series") series: Int? = null,
        @Query("events") events: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("orderBy") orderBy: CharacterOrder? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): CharacterDataWrapper
}