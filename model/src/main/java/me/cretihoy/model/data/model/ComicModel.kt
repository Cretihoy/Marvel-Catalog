package me.cretihoy.model.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @property ComicModel
 *
 * @property id (int, optional): The unique ID of the comic resource.,
 * @property digitalId (int, optional): The ID of the digital comic representation of this comic. Will be 0 if the comic is not available digitally.,
 * @property title (string, optional): The canonical title of the comic.,
 * @property issueNumber (double, optional): The number of the issue in the series (will generally be 0 for collection formats).,
 * @property variantDescription (string, optional): If the issue is a variant (e.g. an alternate cover, second printing, or director’s cut), a text description of the variant.,
 * @property description (string, optional): The preferred description of the comic.,
 * @property modified (Date, optional): The date the resource was most recently modified.,
 * @property isbn (string, optional): The ISBN for the comic (generally only populated for collection formats).,
 * @property upc (string, optional): The UPC barcode number for the comic (generally only populated for periodical formats).,
 * @property diamondCode (string, optional): The Diamond code for the comic.,
 * @property ean (string, optional): The EAN barcode for the comic.,
 * @property issn (string, optional): The ISSN barcode for the comic.,
 * @property format (string, optional): The publication format of the comic e.g. comic, hardcover, trade paperback.,
 * @property pageCount (int, optional): The number of story pages in the comic.,
 * @property textObjects (Array[TextObject], optional): A set of descriptive text blurbs for the comic.,
 * @property resourceURI (string, optional): The canonical URL identifier for this resource.,
 * @property urls (Array[Url], optional): A set of public web site URLs for the resource.,
 * @property series (SeriesSummary, optional): A summary representation of the series to which this comic belongs.,
 * @property variants (Array[ComicSummary], optional): A list of variant issues for this comic (includes the "original" issue if the current issue is a variant).,
 * @property collections (Array[ComicSummary], optional): A list of collections which include this comic (will generally be empty if the comic's format is a collection).,
 * @property collectedIssues (Array[ComicSummary], optional): A list of issues collected in this comic (will generally be empty for periodical formats such as "comic" or "magazine").,
 * @property dates (Array[ComicDate], optional): A list of key dates for this comic.,
 * @property prices (Array[ComicPrice], optional): A list of prices for this comic.,
 * @property thumbnail (Image, optional): The representative image for this comic.,
 * @property images (Array[ImageModel], optional): A list of promotional images associated with this comic.,
 * @property creators (CreatorList, optional): A resource list containing the creators associated with this comic.,
 * @property characters (CharacterList, optional): A resource list containing the characters which appear in this comic.,
 * @property stories (StoryList, optional): A resource list containing the stories which appear in this comic.,
 * @property events (EventList, optional): A resource list containing the events in which this comic appears.
 */

data class ComicModel(

    @SerializedName("id")
    @Expose
    val id: Int?, // 82967

    @SerializedName("digitalId")
    @Expose
    val digitalId: Int?, // 0

    @SerializedName("title")
    @Expose
    val title: String?, // Marvel Previews (2017)

    @SerializedName("issueNumber")
    @Expose
    val issueNumber: Double?, // 0

    @SerializedName("variantDescription")
    @Expose
    val variantDescription: String?,

    @SerializedName("description")
    @Expose
    val description: String?,

    @SerializedName("modified")
    @Expose
    val modified: String?, // 2019-11-07T08:46:15-0500

    @SerializedName("isbn")
    @Expose
    val isbn: String?,

    @SerializedName("upc")
    @Expose
    val upc: String?, // 75960608839302811

    @SerializedName("diamondCode")
    @Expose
    val diamondCode: String?,

    @SerializedName("ean")
    @Expose
    val ean: String?,

    @SerializedName("issn")
    @Expose
    val issn: String?,

    @SerializedName("format")
    @Expose
    val format: String?,

    @SerializedName("pageCount")
    @Expose
    val pageCount: Int?, // 112

    @SerializedName("textObjects")
    @Expose
    val textObjects: List<TextObject>?,

    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/comics/82967

    @SerializedName("urls")
    @Expose
    val urls: List<Url>?,

    @SerializedName("series")
    @Expose
    val series: SeriesSummary?,

    @SerializedName("variants")
    @Expose
    val variants: List<ComicSummary>?,

    @SerializedName("collections")
    @Expose
    val collections: List<ComicSummary>?,

    @SerializedName("collectedIssues")
    @Expose
    val collectedIssues: List<ComicSummary>?,

    @SerializedName("dates")
    @Expose
    val dates: List<ComicDate>?,

    @SerializedName("prices")
    @Expose
    val prices: List<ComicPrice>?,

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: ImageModel?,

    @SerializedName("images")
    @Expose
    val images: List<ImageModel>?,

    @SerializedName("creators")
    @Expose
    val creators: CreatorList?,

    @SerializedName("characters")
    @Expose
    val characters: CharacterList?,

    @SerializedName("stories")
    @Expose
    val stories: StoryList?,

    @SerializedName("events")
    @Expose
    val events: EventList?,
) : BaseItem {

    override fun getImageOrNull(): ImageModel? {
        return thumbnail
    }

    override fun getTitleOrNull(): String? {
        return title
    }

}