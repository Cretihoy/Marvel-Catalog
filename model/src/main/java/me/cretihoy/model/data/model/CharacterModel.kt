package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property CharacterModel
 *
 * @property id (int, optional): The unique ID of the character resource.,
 * @property name (string, optional): The name of the character.,
 * @property description (string, optional): A short bio or description of the character.,
 * @property modified (Date, optional): The date the resource was most recently modified.,
 * @property resourceURI (string, optional): The canonical URL identifier for this resource.,
 * @property urls (Array[Url], optional): A set of public web site URLs for the resource.,
 * @property thumbnail (Image, optional): The representative image for this character.,
 * @property comics (ComicList, optional): A resource list containing comics which feature this character.,
 * @property stories (StoryList, optional): A resource list of stories in which this character appears.,
 * @property events (EventList, optional): A resource list of events in which this character appears.,
 * @property series (SeriesList, optional): A resource list of series in which this character appears.
 */

data class CharacterModel(

    @SerializedName("id")
    @Expose
    val id: Int?, // 1011334

    @SerializedName("name")
    @Expose
    val name: String?, // 3-D Man

    @SerializedName("description")
    @Expose
    val description: String?,

    @SerializedName("modified")
    @Expose
    val modified: String?, // 2014-04-29T14:18:17-0400

    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/characters/1011334

    @SerializedName("urls")
    @Expose
    val urls: List<Url>?,

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: ImageModel?,

    @SerializedName("comics")
    @Expose
    val comics: ComicList?,

    @SerializedName("stories")
    @Expose
    val stories: StoryList?,

    @SerializedName("events")
    @Expose
    val events: EventList?,

    @SerializedName("series")
    @Expose
    val series: SeriesList?,
) : BaseItem {

    override fun getImageOrNull(): ImageModel? {
        return thumbnail
    }

    override fun getTitleOrNull(): String? {
        return name
    }
}
