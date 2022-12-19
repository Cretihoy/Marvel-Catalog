package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property ComicSummary
 *
 * @property resourceURI (string, optional): The path to the individual comic resource.,
 * @property name (string, optional): The canonical name of the comic.
 */

data class ComicSummary(

    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/comics/21366

    @SerializedName("name")
    @Expose
    val name: String?, // Avengers: The Initiative (2007) #14
)