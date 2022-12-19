package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * @property StoryModel
 *
 * @property id (int, optional): The unique ID of the story resource.,
 * @property title (string, optional): The story title.,
 * @property description (string, optional): A short description of the story.,
 * @property resourceURI (string, optional): The canonical URL identifier for this resource. ,
 * @property type (string, optional): The story type e.g. interior story, cover, text story.,
 * @property modified (Date, optional): The date the resource was most recently modified.,
 * @property thumbnail (Image, optional): The representative image for this story.,
 * @property comics (ComicList, optional): A resource list containing comics in which this story takes place.,
 * @property series (SeriesList, optional): A resource list containing series in which this story appears.,
 * @property events (EventList, optional): A resource list of the events in which this story appears.,
 * @property characters (CharacterList, optional): A resource list of characters which appear in this story.,
 * @property creators (CreatorList, optional): A resource list of creators who worked on this story.,
 * @property originalIssue (ComicSummary, optional): A summary representation of the issue in which this story was originally published.
 */

data class StoryModel(

    @SerializedName("id")
    @Expose
    val id: Int?, // 7

    @SerializedName("title")
    @Expose
    val title: String?, // Investigating the murder of a teenage girl, Cage suddenly learns that a three-way gang war is under way for control of the turf

    @SerializedName("description")
    @Expose
    val description: String?,

    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/stories/7

    @SerializedName("type")
    @Expose
    val type: String?, // story

    @SerializedName("modified")
    @Expose
    val modified: Date?, // 1969-12-31T19:00:00-0500

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: ImageModel?, // null

    @SerializedName("comics")
    @Expose
    val comics: ComicList?,

    @SerializedName("series")
    @Expose
    val series: SeriesList?,

    @SerializedName("events")
    @Expose
    val events: EventList?,

    @SerializedName("characters")
    @Expose
    val characters: CharacterList?,

    @SerializedName("creators")
    @Expose
    val creators: CreatorList?,

    @SerializedName("originalIssue")
    @Expose
    val originalIssue: ComicSummary?
) : BaseItem {

    override fun getImageOrNull(): ImageModel? {
        return thumbnail
    }

    override fun getTitleOrNull(): String? {
        return title
    }
}