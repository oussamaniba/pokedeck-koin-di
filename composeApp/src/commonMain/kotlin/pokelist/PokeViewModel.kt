package pokelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import models.PokeData
import repository.PokeDeckRepository

class PokeViewModel(
    private val pokeDeckRepository: PokeDeckRepository
) : ViewModel() {

    private val pokeList = MutableStateFlow<PokeData?>(null)
    val getList get() = pokeList.asStateFlow()

    init {
        getPokeListData()
    }

    fun getPokeListData() {
        viewModelScope.launch {
            val result = pokeDeckRepository.getDeckList()
            if(result is PokeData && result != null) {
                pokeList.value = result
            }
        }
    }

}