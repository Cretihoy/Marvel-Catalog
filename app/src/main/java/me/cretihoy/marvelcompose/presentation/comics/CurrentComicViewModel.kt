package me.cretihoy.marvelcompose.presentation.comics

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.cretihoy.model.data.model.CharacterModel
import me.cretihoy.model.data.model.CreatorModel
import me.cretihoy.model.data.model.SeriesModel
import me.cretihoy.model.data.model.EventModel
import me.cretihoy.model.data.model.StoryModel
import me.cretihoy.service.data.service.ComicService
import javax.inject.Inject

@HiltViewModel
class CurrentComicViewModel
@Inject constructor(
    private val comicService: ComicService
) : ViewModel() {

    val comic = mutableStateOf(ComicStorage.currentComic)
    val characters = mutableStateOf(listOf<CharacterModel>())
    val creators = mutableStateOf(listOf<CreatorModel>())
    val events = mutableStateOf(listOf<EventModel>())
    val series = mutableStateOf(listOf<SeriesModel>())
    val stories = mutableStateOf(listOf<StoryModel>())

    init {
        loadCharacters()
        loadCreators()
        loadEvents()
        loadStories()
        loadSeries()
    }

    private fun loadCharacters() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = comicService.getCharactersByComicId(
                    comicId = comic.value?.id ?: 0
                )
                characters.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }
    private fun loadCreators() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = comicService.getCreatorsByComicId(
                    comicId = comic.value?.id ?: 0
                )
                creators.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }
    private fun loadEvents() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = comicService.getEventsByComicId(
                    comicId = comic.value?.id ?: 0
                )
                events.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }
    private fun loadStories() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = comicService.getStoriesByComicId(
                    comicId = comic.value?.id ?: 0
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
                val result = comicService.getSeriesByComicId(
                    comicId = comic.value?.id ?: 0
                )
                series.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }
}