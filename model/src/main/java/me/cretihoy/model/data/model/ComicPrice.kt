package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property ComicPrice
 *
 * @property type (string, optional): A description of the price (e.g. print price, digital price).,
 * @property price (float, optional): The price (all prices in USD).
 */

data class ComicPrice(

    @SerializedName("type")
    @Expose
    val type: String?, // printPrice

    @SerializedName("price")
    @Expose
    val price: Float?, // 0
)