package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property SeriesModel
 *
 * @property id (int, optional): The unique ID of the series resource.,
 * @property title (string, optional): The canonical title of the series.,
 * @property description (string, optional): A description of the series.,
 * @property resourceURI (string, optional): The canonical URL identifier for this resource.,
 * @property urls (Array[Url], optional): A set of public web site URLs for the resource.,
 * @property startYear (int, optional): The first year of publication for the series.,
 * @property endYear (int, optional): The last year of publication for the series (conventionally, 2099 for ongoing series) .,
 * @property rating (string, optional): The age-appropriateness rating for the series.,
 * @property modified (Date, optional): The date the resource was most recently modified.,
 * @property thumbnail (Image, optional): The representative image for this series.,
 * @property comics (ComicList, optional): A resource list containing comics in this series.,
 * @property stories (StoryList, optional): A resource list containing stories which occur in comics in this series.,
 * @property events (EventList, optional): A resource list containing events which take place in comics in this series.,
 * @property characters (CharacterList, optional): A resource list containing characters which appear in comics in this series.,
 * @property creators (CreatorList, optional): A resource list of creators whose work appears in comics in this series.,
 * @property next (SeriesSummary, optional): A summary representation of the series which follows this series.,
 * @property previous (SeriesSummary, optional): A summary representation of the series which preceded this series.
 */

data class SeriesModel(

    @SerializedName("id")
    @Expose
    val id: Int?, // 31445

    @SerializedName("title")
    @Expose
    val title: String?, //  Fantastic Four by Dan Slott Vol. 1 (2021)

    @SerializedName("description")
    @Expose
    val description: String?, // null

    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/series/31445

    @SerializedName("urls")
    @Expose
    val urls: List<Url>?,

    @SerializedName("startYear")
    @Expose
    val startYear: Int?, // 2021

    @SerializedName("endYear")
    @Expose
    val endYear: Int?, // 2021

    @SerializedName("rating")
    @Expose
    val rating: String?,

    @SerializedName("modified")
    @Expose
    val modified: String?, // 2020-07-29T09:04:18-0400

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

    @SerializedName("characters")
    @Expose
    val characters: CharacterList?,

    @SerializedName("creators")
    @Expose
    val creators: CreatorList?,

    @SerializedName("next")
    @Expose
    val next: SeriesSummary?, // null

    @SerializedName("previous")
    @Expose
    val previous: SeriesSummary? // null
) : BaseItem {

    override fun getImageOrNull(): ImageModel? {
        return thumbnail
    }

    override fun getTitleOrNull(): String? {
        return title
    }

}