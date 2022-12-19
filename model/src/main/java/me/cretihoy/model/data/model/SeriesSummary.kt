package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property SeriesSummary
 *
 * @property resourceURI (string, optional): The path to the individual series resource.,
 * @property name (string, optional): The canonical name of the series.
 */

data class SeriesSummary(

    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/series/1945

    @SerializedName("name")
    @Expose
    val name: String?, // Avengers: The Initiative (2007 - 2010)
)