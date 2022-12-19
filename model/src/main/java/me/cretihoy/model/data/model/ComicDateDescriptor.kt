package me.cretihoy.model.data.model

import com.google.gson.annotations.SerializedName

enum class ComicDateDescriptor(val value: String) {

    @SerializedName("lastWeek")
    LAST_WEEK("lastWeek"),

    @SerializedName("thisWeek")
    THIS_WEEK("thisWeek"),

    @SerializedName("nextWeek")
    NEXT_WEEK("nextWeek"),

    @SerializedName("thisMonth")
    THIS_MONTH("thisMonth")
}