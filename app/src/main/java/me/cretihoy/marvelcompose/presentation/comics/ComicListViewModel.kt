package me.cretihoy.marvelcompose.presentation.comics

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.cretihoy.marvelcompose.ui.theme.EMPTY_STRING
import me.cretihoy.model.data.model.ComicModel
import me.cretihoy.service.data.service.ComicService
import javax.inject.Inject

@HiltViewModel
class ComicListViewModel
@Inject constructor(
    private val comicService: ComicService,
) : ViewModel() {

    val searchText = mutableStateOf("marvel")
    val errorMessage = mutableStateOf(EMPTY_STRING)
    val comics: MutableState<List<ComicModel>> = mutableStateOf(listOf())

    fun onButtonClicked() {
        loadComics()
    }

    private fun loadComics() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = comicService.getComics(titleStartsWith = searchText.value)
                comics.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                errorMessage.value = e.localizedMessage ?: e.message ?: EMPTY_STRING
            }
        }
    }
}