package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property EventList
 *
 * @property available (int, optional): The number of total available events in this list. Will always be greater than or equal to the "returned" value.,
 * @property returned (int, optional): The number of events returned in this collection (up to 20).,
 * @property collectionURI (string, optional): The path to the full list of events in this collection.,
 * @property items (Array[EventSummary], optional): The list of returned events in this collection.
 */

data class EventList(

    @SerializedName("available")
    @Expose
    val available: Int?, // 1

    @SerializedName("returned")
    @Expose
    val returned: Int?, // 1

    @SerializedName("collectionURI")
    @Expose
    val collectionURI: String?, // http://gateway.marvel.com/v1/public/characters/1011334/events

    @SerializedName("items")
    @Expose
    val items: List<EventSummary>?,
)