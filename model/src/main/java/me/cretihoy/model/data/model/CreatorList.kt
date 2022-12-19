package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property CreatorList
 *
 * @property available (int, optional): The number of total available creators in this list. Will always be greater than or equal to the "returned" value.,
 * @property returned (int, optional): The number of creators returned in this collection (up to 20).,
 * @property collectionURI (string, optional): The path to the full list of creators in this collection.,
 * @property items (Array[CreatorSummary], optional): The list of returned creators in this collection.
 */

data class CreatorList(

    @SerializedName("available")
    @Expose
    val available: Int, // 1

    @SerializedName("returned")
    @Expose
    val returned: Int?, // 1

    @SerializedName("collectionURI")
    @Expose
    val collectionURI: String?, // http://gateway.marvel.com/v1/public/comics/82967/creators

    @SerializedName("items")
    @Expose
    val items: List<CreatorSummary>?,
)