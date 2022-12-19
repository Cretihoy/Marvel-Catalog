package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property ComicDate
 *
 * @property type (string, optional): A description of the date (e.g. onsale date, FOC date).,
 * @property date (Date, optional): The date.
 */

data class ComicDate(

    @SerializedName("type")
    @Expose
    val type: String?, // onsaleDate

    @SerializedName("date")
    @Expose
    val date: String?, // 2099-10-30T00:00:00-0500
)