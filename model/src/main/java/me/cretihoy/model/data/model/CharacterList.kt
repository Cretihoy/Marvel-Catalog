package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property CharacterList
 *
 * @property available (int, optional): The number of total available characters in this list. Will always be greater than or equal to the "returned" value.,
 * @property returned (int, optional): The number of characters returned in this collection (up to 20).,
 * @property collectionURI (string, optional): The path to the full list of characters in this collection.,
 * @property items (Array[CharacterSummary], optional): The list of returned characters in this collection.
 */

data class CharacterList(

    @SerializedName("available")
    @Expose
    val available: Int?, // 0

    @SerializedName("returned")
    @Expose
    val returned: Int?, // 0

    @SerializedName("collectionURI")
    @Expose
    val collectionURI: String?, // http://gateway.marvel.com/v1/public/comics/82967/characters

    @SerializedName("items")
    @Expose
    val items: List<CharacterSummary>?,
)