package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property  ComicList
 *
 * @property available (int, optional): The number of total available issues in this list. Will always be greater than or equal to the "returned" value.,
 * @property returned (int, optional): The number of issues returned in this collection (up to 20).,
 * @property collectionURI (string, optional): The path to the full list of issues in this collection.,
 * @property items (Array[ComicSummary], optional): The list of returned issues in this collection.
 */

data class ComicList(

    @SerializedName("available")
    @Expose
    val available: Int?, // 12

    @SerializedName("returned")
    @Expose
    val returned: Int?, // 12

    @SerializedName("collectionURI")
    @Expose
    val collectionURI: String?, // http://gateway.marvel.com/v1/public/characters/1011334/comics

    @SerializedName("items")
    @Expose
    val items: List<ComicSummary>?,
)