package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property CharacterSummary
 *
 * @property resourceURI (string, optional): The path to the individual character resource.,
 * @property name (string, optional): The full name of the character.,
 * @property role (string, optional): The role of the creator in the parent entity.
 */

data class CharacterSummary(

    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/creators/2707

    @SerializedName("name")
    @Expose
    val name: String?, // Jeff Albrecht

    @SerializedName("role")
    @Expose
    val role: String?, // inker
)