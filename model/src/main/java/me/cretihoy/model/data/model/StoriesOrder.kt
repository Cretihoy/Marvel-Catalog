package me.cretihoy.model.data.model

import com.google.gson.annotations.SerializedName

enum class StoriesOrder(val value: String) {

    @SerializedName("id")
    ID("id"),

    @SerializedName("modified")
    MODIFIED("modified"),

    @SerializedName("-id")
    INVERT_ID("-id"),

    @SerializedName("-modified")
    INVERT_MODIFIED("-modified"),
}