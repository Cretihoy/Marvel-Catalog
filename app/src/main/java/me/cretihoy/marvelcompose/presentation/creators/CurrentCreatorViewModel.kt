package me.cretihoy.marvelcompose.presentation.creators

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
import me.cretihoy.service.data.service.CreatorService
import javax.inject.Inject

@HiltViewModel
class CurrentCreatorViewModel
@Inject constructor(
    private val creatorService: CreatorService
) : ViewModel() {

    val creator = mutableStateOf(CreatorStorage.currentCreator)
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
                val result = creatorService.getComicsByCreatorId(
                    creatorId = creator.value?.id ?: 0
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
                val result = creatorService.getStoriesByCreatorId(
                    creatorId = creator.value?.id ?: 0
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
                val result = creatorService.getSeriesByCreatorId(
                    creatorId = creator.value?.id ?: 0
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
                val result = creatorService.getEventsByCreatorId(
                    creatorId = creator.value?.id ?: 0
                )
                events.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                // todo: refresh button & error processor
            }
        }
    }
}