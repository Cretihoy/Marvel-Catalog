package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property CreatorModel
 *
 * @property id (int, optional): The unique ID of the creator resource.,
 * @property firstName (string, optional): The first name of the creator.,
 * @property middleName (string, optional): The middle name of the creator.,
 * @property lastName (string, optional): The last name of the creator.,
 * @property suffix (string, optional): The suffix or honorific for the creator.,
 * @property fullName (string, optional): The full name of the creator (a space-separated concatenation of the above four fields).,
 * @property modified (Date, optional): The date the resource was most recently modified.,
 * @property resourceURI (string, optional): The canonical URL identifier for this resource.,
 * @property urls (Array[Url], optional): A set of public web site URLs for the resource.,
 * @property thumbnail (Image, optional): The representative image for this creator.,
 * @property series (SeriesList, optional): A resource list containing the series which feature work by this creator.,
 * @property stories (StoryList, optional): A resource list containing the stories which feature work by this creator.,
 * @property comics (ComicList, optional): A resource list containing the comics which feature work by this creator.,
 * @property events (EventList, optional): A resource list containing the events which feature work by this creator.
 */

data class CreatorModel(

    @SerializedName("id")
    @Expose
    val id: Int?, // 13970

    @SerializedName("firstName")
    @Expose
    val firstName: String?, // #O

    @SerializedName("middleName")
    @Expose
    val middleName: String?,

    @SerializedName("lastName")
    @Expose
    val lastName: String?,

    @SerializedName("suffix")
    @Expose
    val suffix: String?,

    @SerializedName("fullName")
    @Expose
    val fullName: String?, // #O

    @SerializedName("modified")
    @Expose
    val modified: String?, // 2019-12-11T17:10:07-0500

    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/creators/13970

    @SerializedName("urls")
    @Expose
    val urls: List<Url>?,

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: ImageModel?,

    @SerializedName("series")
    @Expose
    val series: SeriesList?,

    @SerializedName("stories")
    @Expose
    val stories: StoryList?,

    @SerializedName("comics")
    @Expose
    val comics: ComicList?,

    @SerializedName("events")
    @Expose
    val events: EventList?,
) : BaseItem {

    override fun getImageOrNull(): ImageModel? {
        return thumbnail
    }

    override fun getTitleOrNull(): String? {
        return fullName
    }

}