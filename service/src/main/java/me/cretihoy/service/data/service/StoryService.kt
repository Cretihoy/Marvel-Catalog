package me.cretihoy.service.data.service

import me.cretihoy.model.data.model.StoriesOrder
import me.cretihoy.model.data.model.StoryDataWrapper
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface StoryService {

    @GET("/v1/public/stories")
    suspend fun getStories(
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: Int? = null,
        @Query("series") series: Int? = null,
        @Query("events") events: Int? = null,
        @Query("creators") creators: Int? = null,
        @Query("characters") characters: Int? = null,
        @Query("orderBy") orderBy: StoriesOrder? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): StoryDataWrapper
}