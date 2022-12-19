package me.cretihoy.marvelcompose.presentation.characters

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.cretihoy.marvelcompose.ui.theme.EMPTY_STRING
import me.cretihoy.marvelcompose.ui.theme.ERROR_MESSAGE
import me.cretihoy.model.data.model.CharacterModel
import me.cretihoy.service.data.service.CharacterService
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel
@Inject constructor(
    private val characterService: CharacterService
) : ViewModel() {

    val searchText = mutableStateOf("Spider")
    val errorMessage = mutableStateOf(EMPTY_STRING)
    val characters: MutableState<List<CharacterModel>> = mutableStateOf(listOf())

    fun onButtonClicked() {
        loadCharacters()
    }

    private fun loadCharacters() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = characterService.getCharacters(nameStartsWith = searchText.value)
                characters.value = result.data?.results ?: listOf()
            } catch (e: Exception) {
                errorMessage.value = e.localizedMessage ?: e.message ?: ERROR_MESSAGE
            }
        }
    }
}