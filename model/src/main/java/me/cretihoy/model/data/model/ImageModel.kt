package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property ImageModel
 *
 * @property path (string, optional): The directory path of to the image.,
 * @property extension (string, optional): The file extension for the image.
 */

data class ImageModel(

    @SerializedName("path")
    @Expose
    val path: String?, // http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784

    @SerializedName("extension")
    @Expose
    val extension: String?, // jpg
) {

    fun getFullUrl(): String? {
        return if (path.isNullOrEmpty() || extension.isNullOrEmpty()) {
            null
        } else {
            "$path.$extension"
        }
    }
}