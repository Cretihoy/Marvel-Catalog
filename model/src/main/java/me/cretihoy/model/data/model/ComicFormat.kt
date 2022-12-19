package me.cretihoy.model.data.model

import com.google.gson.annotations.SerializedName

enum class ComicFormat(val value: String) {

    @SerializedName("comic")
    COMIC("comic"),

    @SerializedName("magazine")
    MAGAZINE("magazine"),

    @SerializedName("trade paperback")
    TRADE_PAPERBACK("trade paperback"),

    @SerializedName("hardcover")
    HARDCOVER("hardcover"),

    @SerializedName("digest")
    DIGEST("digest"),

    @SerializedName("graphic novel")
    GRAPHIC_NOVEL("graphic novel"),

    @SerializedName("digital comic")
    DIGITAL_COMIC("digital comic"),

    @SerializedName("infinite comic")
    INFINITE_COMIC("infinite comic"),
}