package me.cretihoy.marvelcompose.presentation.events

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.cretihoy.marvelcompose.ui.theme.EMPTY_STRING
import me.cretihoy.model.data.model.EventModel
import me.cretihoy.service.data.service.EventService
import javax.inject.Inject

@HiltViewModel
class EventListViewModel
@Inject constructor(
    private val eventService: EventService
) : ViewModel() {

    val searchText = mutableStateOf("deadpool")
    val errorMessage = mutableStateOf(EMPTY_STRING)
    val events: MutableState<List<EventModel>> = mutableStateOf(listOf())

    fun onButtonClicked() {
        loadEvents()
    }

    private fun loadEvents() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = eventService.getEvents(nameStartsWith = searchText.value)
                events.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                errorMessage.value = e.localizedMessage ?: e.message ?: EMPTY_STRING
            }
        }
    }
}