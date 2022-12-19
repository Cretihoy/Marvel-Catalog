package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property StorySummary
 *
 * @property resourceURI (string, optional): The path to the individual story resource.,
 * @property name (string, optional): The canonical name of the story.,
 * @property type (string, optional): The type of the story (interior or cover).
 */

data class StorySummary(

    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/stories/19947

    @SerializedName("name")
    @Expose
    val name: String?, // Cover #19947

    @SerializedName("type")
    @Expose
    val type: String?, // cover
)