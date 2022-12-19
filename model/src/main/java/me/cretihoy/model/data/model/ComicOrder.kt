package me.cretihoy.model.data.model

import com.google.gson.annotations.SerializedName

enum class ComicOrder(val value: String) {

    @SerializedName("focDate")
    FOCDATE("focDate"),

    @SerializedName("onsaleDate")
    ONSALEDATE("onsaleDate"),

    @SerializedName("title")
    TITLE("title"),

    @SerializedName("issueNumber")
    ISSUENUMBER("issueNumber"),

    @SerializedName("modified")
    MODIFIED("modified"),

    @SerializedName("-focDate")
    INVERT_FOCDATE("-focDate"),

    @SerializedName("-onsaleDate")
    INVERT_ONSALEDATE("-onsaleDate"),

    @SerializedName("-title")
    INVERT_TITLE("-title"),

    @SerializedName("-issueNumber")
    INVERT_ISSUENUMBER("-issueNumber"),

    @SerializedName("-modified")
    INVERT_MODIFIED("-modified")
}