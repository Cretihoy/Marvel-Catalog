package me.cretihoy.marvelcompose.presentation.creators

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.cretihoy.marvelcompose.ui.theme.EMPTY_STRING
import me.cretihoy.model.data.model.CreatorModel
import me.cretihoy.service.data.service.CreatorService
import javax.inject.Inject

@HiltViewModel
class CreatorListViewModel
@Inject constructor(
    private val creatorService: CreatorService
) : ViewModel() {

    val searchText = mutableStateOf("deadpool")
    val errorMessage = mutableStateOf(EMPTY_STRING)
    val creators: MutableState<List<CreatorModel>> = mutableStateOf(listOf())

    fun onButtonClicked() {
        loadCreators()
    }

    private fun loadCreators() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = creatorService.getCreators(nameStartsWith = searchText.value)
                creators.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                errorMessage.value = e.localizedMessage ?: e.message ?: EMPTY_STRING
            }
        }
    }
}