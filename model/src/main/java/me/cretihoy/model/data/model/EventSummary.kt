package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property EventSummary
 *
 * @property resourceURI (string, optional): The path to the individual event resource.,
 * @property name (string, optional): The name of the event.
 */

data class EventSummary(

    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/events/269

    @SerializedName("name")
    @Expose
    val name: String?, // Secret Invasion
)