package me.cretihoy.marvelcompose.presentation.events

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.cretihoy.model.data.model.CharacterModel
import me.cretihoy.model.data.model.ComicModel
import me.cretihoy.model.data.model.CreatorModel
import me.cretihoy.model.data.model.SeriesModel
import me.cretihoy.model.data.model.StoryModel
import me.cretihoy.service.data.service.EventService
import javax.inject.Inject

@HiltViewModel
class CurrentEventViewModel
@Inject constructor(
    private val eventService: EventService
) : ViewModel() {

    val event = mutableStateOf(EventStorage.currentEvent)
    val characters = mutableStateOf(listOf<CharacterModel>())
    val comics = mutableStateOf(listOf<ComicModel>())
    val stories = mutableStateOf(listOf<StoryModel>())
    val series = mutableStateOf(listOf<SeriesModel>())
    val creators = mutableStateOf(listOf<CreatorModel>())

    init {
        loadCharacters()
        loadComics()
        loadStories()
        loadSeries()
        loadCreators()
    }

    private fun loadCharacters() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = eventService.getCharactersByEventId(
                    eventId = event.value?.id ?: 0
                )
                characters.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }

    private fun loadComics() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = eventService.getComicsByEventId(
                    eventId = event.value?.id ?: 0
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
                val result = eventService.getStoriesByEventId(
                    eventId = event.value?.id ?: 0
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
                val result = eventService.getSeriesByEventId(
                    eventId = event.value?.id ?: 0
                )
                series.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }
    private fun loadCreators() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = eventService.getCreatorsByEventId(
                    eventId = event.value?.id ?: 0
                )
                creators.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }
}