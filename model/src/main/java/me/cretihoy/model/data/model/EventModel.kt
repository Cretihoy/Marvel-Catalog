package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property EventModel
 *
 * @property id (int, optional): The unique ID of the event resource.,
 * @property title (string, optional): The title of the event.,
 * @property description (string, optional): A description of the event.,
 * @property resourceURI (string, optional): The canonical URL identifier for this resource.,
 * @property urls (Array[Url], optional): A set of public web site URLs for the event.,
 * @property modified (Date, optional): The date the resource was most recently modified.,
 * @property start (Date, optional): The date of publication of the first issue in this event.,
 * @property end (Date, optional): The date of publication of the last issue in this event.,
 * @property thumbnail (Image, optional): The representative image for this event.,
 * @property comics (ComicList, optional): A resource list containing the comics in this event.,
 * @property stories (StoryList, optional): A resource list containing the stories in this event.,
 * @property series (SeriesList, optional): A resource list containing the series in this event.,
 * @property characters (CharacterList, optional): A resource list containing the characters which appear in this event.,
 * @property creators (CreatorList, optional): A resource list containing creators whose work appears in this event.,
 * @property next (EventSummary, optional): A summary representation of the event which follows this event.,
 * @property previous (EventSummary, optional): A summary representation of the event which preceded this event.
 */

data class EventModel(

    @SerializedName("id")
    @Expose
    val id: Int?, // 116

    @SerializedName("title")
    @Expose
    val title: String?, // Acts of Vengeance!

    @SerializedName("description")
    @Expose
    val description: String?, // Loki sets about convincing the super-villains of Earth to attack heroes other than those they normally fight in an attempt to destroy the Avengers to absolve his guilt over inadvertently creating the team in the first place.

    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/events/116

    @SerializedName("urls")
    @Expose
    val urls: List<Url>?,

    @SerializedName("modified")
    @Expose
    val modified: String?, // 2013-06-28T16:31:24-0400

    @SerializedName("start")
    @Expose
    val start: String?, // 1989-12-10 00:00:00 //

    @SerializedName("end")
    @Expose
    val end: String?, // 2008-01-04 00:00:00 //

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: ImageModel?,

    @SerializedName("comics")
    @Expose
    val comics: ComicList?,

    @SerializedName("stories")
    @Expose
    val stories: StoryList?,

    @SerializedName("series")
    @Expose
    val series: SeriesList?,

    @SerializedName("characters")
    @Expose
    val characters: CharacterList?,

    @SerializedName("creators")
    @Expose
    val creators: CreatorList?,

    @SerializedName("next")
    @Expose
    val next: EventSummary?,

    @SerializedName("previous")
    @Expose
    val previous: EventSummary?,
) : BaseItem {

    override fun getImageOrNull(): ImageModel? {
        return thumbnail
    }

    override fun getTitleOrNull(): String? {
        return title
    }

}