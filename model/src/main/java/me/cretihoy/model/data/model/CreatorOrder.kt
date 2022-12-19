package me.cretihoy.model.data.model

import com.google.gson.annotations.SerializedName

enum class CreatorOrder(val value: String) {

    @SerializedName("lastName")
    LAST_NAME("lastName"),

    @SerializedName("firstName")
    FIRST_NAME("firstName"),

    @SerializedName("middleName")
    MIDDLE_NAME("middleName"),

    @SerializedName("suffix")
    SUFFIX("suffix"),

    @SerializedName("modified")
    MODIFIED("modified"),

    @SerializedName("-lastName")
    INVERT_LAST_NAME("-lastName"),

    @SerializedName("-firstName")
    INVERT_FIRST_NAME("-firstName"),

    @SerializedName("-middleName")
    INVERT_MIDDLE_NAME("-middleName"),

    @SerializedName("-suffix")
    INVERT_SUFFIX("-suffix"),

    @SerializedName("-modified")
    INVERT_MODIFIED("-modified"),
}