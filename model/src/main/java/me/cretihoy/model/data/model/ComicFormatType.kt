package me.cretihoy.model.data.model

import com.google.gson.annotations.SerializedName

enum class ComicFormatType(val value: String) {

    @SerializedName("comic")
    COMIC("comic"),

    @SerializedName("collection")
    COLLECTION("collection"),
}