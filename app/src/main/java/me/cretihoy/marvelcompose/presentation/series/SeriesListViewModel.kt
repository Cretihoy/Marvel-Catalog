package me.cretihoy.marvelcompose.presentation.series

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.cretihoy.marvelcompose.ui.theme.EMPTY_STRING
import me.cretihoy.model.data.model.SeriesModel
import me.cretihoy.service.data.service.SeriesService
import javax.inject.Inject

@HiltViewModel
class SeriesListViewModel
@Inject constructor(
    private val seriesService: SeriesService
) : ViewModel() {

    val searchText = mutableStateOf("deadpool")
    val errorMessage = mutableStateOf(EMPTY_STRING)
    val series: MutableState<List<SeriesModel>> = mutableStateOf(listOf())

    fun onButtonClicked() {
        loadSeries()
    }

    private fun loadSeries() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = seriesService.getSeries(titleStartsWith = searchText.value)
                series.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                errorMessage.value = e.localizedMessage ?: e.message ?: EMPTY_STRING
            }
        }
    }
}