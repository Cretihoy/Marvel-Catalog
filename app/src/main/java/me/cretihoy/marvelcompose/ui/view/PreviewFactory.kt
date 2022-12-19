package me.cretihoy.marvelcompose.ui.view

import me.cretihoy.marvelcompose.R
import me.cretihoy.model.data.model.CharacterModel
import me.cretihoy.model.data.model.ImageModel
import kotlin.random.Random

object PreviewFactory {

    fun getRandomCharacter(): CharacterModel {
        return CharacterModel(
            null,
            getRandomName(),
            getRandomDescription(),
            null, null,
            null,
            getRandomImageModel(),
            null, null,
            null, null
        )
    }

    fun getRandomName(): String {
        val names = listOf(
            "Stiven",
            "Spider-",
            "Super",
            "Bat",
            "Iron",
            "Marvel",
            "Ant-",
            "Cyber"
        )
        val surnames = listOf(
            "man",
            "girl",
            "woman",
            "boy",
            "dude",
            "guy",
            "bitch"
        )
        val nameIndex = Random.nextInt(names.lastIndex)
        val surnameIndex = Random.nextInt(surnames.lastIndex)
        return "${names[nameIndex]}${surnames[surnameIndex]}"
    }

    fun getRandomDescription(): String? {
        val descriptions = listOf(
            "Miles Gonzalo Morales is a fictional character, a superhero appearing in American comic books published by Marvel Comics, and is one of the characters known as Spider-Man.",
            "Ajax, a twisted scientist, experiments on Wade Wilson, a mercenary, to cure him of cancer and give him healing powers. However, the experiment leaves Wade disfigured and he decides to exact revenge.",
            "Barry Allen, a forensic investigator in Central City, gains the power of superhuman speed from a freak accident. He decides to use it to fight crime as the Flash, a costumed superhero.",
            "Clark Joseph Kent, best known by his superhero persona Superman, is a fictional superhero in the DC Extended Universe series of films, based on the DC Comics character of the same name created by Jerry Siegel and Joe Shuster. ",
            null
        )
        val descriptionIndex = Random.nextInt(descriptions.lastIndex)
        return descriptions[descriptionIndex]
    }

    fun getRandomImageRes(): Int {
        val images = listOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3
        )
        val index = Random.nextInt(images.lastIndex)
        return images[index]
    }

    fun getRandomImageModel(): ImageModel {
        return ImageModel(
            path = getRandomImageRes().toString(),
            extension = null
        )
    }
}