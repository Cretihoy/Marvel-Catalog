package me.cretihoy.model.data.model

import com.google.gson.annotations.SerializedName

enum class EventsOrder(val value: String) {

    @SerializedName("name")
    NAME("name"),

    @SerializedName("startDate")
    START_DATE("startDate"),

    @SerializedName("modified")
    MODIFIED("modified"),

    @SerializedName("-name")
    INVERT_NAME("-name"),

    @SerializedName("-startDate")
    INVERT_START_DATE("-startDate"),

    @SerializedName("-modified")
    INVERT_MODIFIED("-modified"),
}