package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property SeriesDataWrapper
 *
 * @property code (int, optional): The HTTP status code of the returned result.,
 * @property status (string, optional): A string description of the call status.,
 * @property copyright (string, optional): The copyright notice for the returned result.,
 * @property attributionText (string, optional): The attribution notice for this result. Please display either this notice or the contents of the attributionHTML field on all screens which contain data from the Marvel Comics API.,
 * @property attributionHTML (string, optional): An HTML representation of the attribution notice for this result. Please display either this notice or the contents of the attributionText field on all screens which contain data from the Marvel Comics API.,
 * @property data (SeriesDataContainer, optional): The results returned by the call.,
 * @property etag (string, optional): A digest value of the content returned by the call.
 */

data class SeriesDataWrapper(

    @SerializedName("code")
    @Expose
    val code: Int?, // 200

    @SerializedName("status")
    @Expose
    val status: String?, // Ok

    @SerializedName("copyright")
    @Expose
    val copyright: String?, // © 2022 MARVEL

    @SerializedName("attributionText")
    @Expose
    val attributionText: String?, // Data provided by Marvel. © 2022 MARVEL

    @SerializedName("attributionHTML")
    @Expose
    val attributionHTML: String?, // <a href="http://marvel.com">Data provided by Marvel. © 2022 MARVEL</a>

    @SerializedName("data")
    @Expose
    val data: SeriesDataContainer?,

    @SerializedName("etag")
    @Expose
    val etag: String?, // 93859cd5dc794b0bda1cb9893fedea954e670af7
)