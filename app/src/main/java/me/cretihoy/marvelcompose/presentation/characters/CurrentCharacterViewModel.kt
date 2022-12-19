package me.cretihoy.marvelcompose.presentation.characters

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.cretihoy.model.data.model.ComicModel
import me.cretihoy.model.data.model.EventModel
import me.cretihoy.model.data.model.SeriesModel
import me.cretihoy.model.data.model.StoryModel
import me.cretihoy.service.data.service.CharacterService
import javax.inject.Inject

@HiltViewModel
class CurrentCharacterViewModel
@Inject constructor(
    private val characterService: CharacterService
) : ViewModel() {

    val character = mutableStateOf(CharacterStorage.currentCharacter)
    val comics = mutableStateOf(listOf<ComicModel>())
    val stories = mutableStateOf(listOf<StoryModel>())
    val series = mutableStateOf(listOf<SeriesModel>())
    val events = mutableStateOf(listOf<EventModel>())

    init {
        loadComics()
        loadStories()
        loadSeries()
        loadEvents()
    }

    private fun loadComics() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = characterService.getComicsByCharacterId(
                    characterId = character.value?.id ?: 0
                )
                comics.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }

    private fun loadStories() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = characterService.getStoriesByCharacterId(
                    characterId = character.value?.id ?: 0
                )
                stories.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }
    private fun loadSeries() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = characterService.getSeriesByCharacterId(
                    characterId = character.value?.id ?: 0
                )
                series.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }
    private fun loadEvents() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = characterService.getEventsByCharacterId(
                    characterId = character.value?.id ?: 0
                )
                events.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }
}