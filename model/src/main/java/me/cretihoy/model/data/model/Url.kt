package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property Url
 *
 * @property type (string, optional): A text identifier for the URL.,
 * @property url (string, optional): A full URL (including scheme, domain, and path).
 */

data class Url(

    @SerializedName("type")
    @Expose
    val type: String?, // detail

    @SerializedName("url")
    @Expose
    val url: String?, // http://marvel.com/characters/74/3-d_man?utm_campaign=apiRef&utm_source=093ae71df34b6ccabc350350df4433f4
)