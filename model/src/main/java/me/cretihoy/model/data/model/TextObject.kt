package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *  @property TextObject
 *
 * @property type (string, optional): The canonical type of the text object (e.g. solicit text, preview text, etc.).,
 * @property language (string, optional): The IETF language tag denoting the language the text object is written in.,
 * @property text (string, optional): The text.
 */

data class TextObject(

    @SerializedName("type")
    @Expose
    val type: String?,

    @SerializedName("language")
    @Expose
    val language: String?,

    @SerializedName("text")
    @Expose
    val text: String?,
)
