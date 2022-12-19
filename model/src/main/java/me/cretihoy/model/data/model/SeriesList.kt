package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property SeriesList
 *
 * @property available (int, optional): The number of total available series in this list. Will always be greater than or equal to the "returned" value.,
 * @property returned (int, optional): The number of series returned in this collection (up to 20).,
 * @property collectionURI (string, optional): The path to the full list of series in this collection.,
 * @property items (Array[SeriesSummary], optional): The list of returned series in this collection.
 */

data class SeriesList(

    @SerializedName("available")
    @Expose
    val available: Int?, // 3

    @SerializedName("returned")
    @Expose
    val returned: Int?, // 3

    @SerializedName("collectionURI")
    @Expose
    val collectionURI: String?, // http://gateway.marvel.com/v1/public/characters/1011334/series

    @SerializedName("items")
    @Expose
    val items: List<SeriesSummary>?,
)