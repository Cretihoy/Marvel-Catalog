package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property CreatorSummary
 *
 * @property resourceURI (string, optional): The path to the individual creator resource.,
 * @property name (string, optional): The full name of the creator.,
 * @property role (string, optional): The role of the creator in the parent entity.
 */

data class CreatorSummary(

    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/creators/10021

    @SerializedName("name")
    @Expose
    val name: String?, // Jim Nausedas

    @SerializedName("role")
    @Expose
    val role: String?, // editor
)