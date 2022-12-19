package me.cretihoy.model.data.model

import com.google.gson.annotations.SerializedName

enum class CharacterOrder(val value: String) {

    @SerializedName("name")
    NAME("name"),

    @SerializedName("modified")
    MODIFIED("modified"),

    @SerializedName("-name")
    INVERT_NAME("-name"),

    @SerializedName("-modified")
    INVERT_MODIFIED("-modified"),
}