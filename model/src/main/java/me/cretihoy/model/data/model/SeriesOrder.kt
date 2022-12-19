package me.cretihoy.model.data.model

import com.google.gson.annotations.SerializedName

enum class SeriesOrder(val value: String) {

    @SerializedName("title")
    TITLE("title"),

    @SerializedName("modified")
    MODIFIED("modified"),

    @SerializedName("startYear")
    START_YEAR("startYear"),

    @SerializedName("-title")
    INVERT_TITLE("-title"),

    @SerializedName("-modified")
    INVERT_MODIFIED("-modified"),

    @SerializedName("-startYear")
    INVERT_START_YEAR("-startYear"),
}