package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property StoryList
 *
 * @property available (int, optional): The number of total available stories in this list. Will always be greater than or equal to the "returned" value.,
 * @property returned (int, optional): The number of stories returned in this collection (up to 20).,
 * @property collectionURI (string, optional): The path to the full list of stories in this collection.,
 * @property items (Array[StorySummary], optional): The list of returned stories in this collection.
 */

data class StoryList(

    @SerializedName("available")
    @Expose
    val available: Int?, // 21

    @SerializedName("returned")
    @Expose
    val returned: Int?, // 20

    @SerializedName("collectionURI")
    @Expose
    val collectionURI: String?, // http://gateway.marvel.com/v1/public/characters/1011334/stories

    @SerializedName("items")
    @Expose
    val items: List<StorySummary>?,
)