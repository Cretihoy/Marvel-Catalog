package me.cretihoy.marvelcompose.presentation.series

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.cretihoy.model.data.model.CharacterModel
import me.cretihoy.model.data.model.ComicModel
import me.cretihoy.model.data.model.CreatorModel
import me.cretihoy.model.data.model.EventModel
import me.cretihoy.model.data.model.StoryModel
import me.cretihoy.service.data.service.SeriesService
import javax.inject.Inject

@HiltViewModel
class CurrentSeriesViewModel
@Inject constructor(
    private val seriesService: SeriesService
) : ViewModel() {

    val series = mutableStateOf(SeriesStorage.currentSeries)
    val characters = mutableStateOf(listOf<CharacterModel>())
    val creators = mutableStateOf(listOf<CreatorModel>())
    val comics = mutableStateOf(listOf<ComicModel>())
    val stories = mutableStateOf(listOf<StoryModel>())
    val events = mutableStateOf(listOf<EventModel>())

    init {
        loadCharacters()
        loadComics()
        loadStories()
        loadEvents()
        loadCreators()
    }

    private fun loadCharacters() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = seriesService.getCharactersBySeriesId(
                    seriesId = series.value?.id ?: 0
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
                val result = seriesService.getCreatorsBySeriesId(
                    seriesId = series.value?.id ?: 0
                )
                creators.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }

    private fun loadComics() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = seriesService.getComicsBySeriesId(
                    seriesId = series.value?.id ?: 0
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
                val result = seriesService.getStoriesBySeriesId(
                    seriesId = series.value?.id ?: 0
                )
                stories.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }

    private fun loadEvents() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = seriesService.getEventsBySeriesId(
                    seriesId = series.value?.id ?: 0
                )
                events.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }
}