package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property CharacterDataContainer
 *
 * @property offset (int, optional): The requested offset (number of skipped results) of the call.,
 * @property limit (int, optional): The requested result limit.,
 * @property total (int, optional): The total number of resources available given the current filter set.,
 * @property count (int, optional): The total number of results returned by this call.,
 * @property results (Array[CharacterModel], optional): The list of characters returned by the call.
 */

data class CharacterDataContainer(

    @SerializedName("offset")
    @Expose
    val offset: Int?, // 0

    @SerializedName("limit")
    @Expose
    val limit: Int?, // 3

    @SerializedName("total")
    @Expose
    val total: Int?, // 1562

    @SerializedName("count")
    @Expose
    val count: Int?, // 3

    @SerializedName("results")
    @Expose
    val results: List<CharacterModel>?,
)