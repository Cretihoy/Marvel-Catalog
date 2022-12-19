package me.cretihoy.model.data.model

interface BaseItem {

    fun getImageOrNull(): ImageModel?
    fun getTitleOrNull(): String?
}