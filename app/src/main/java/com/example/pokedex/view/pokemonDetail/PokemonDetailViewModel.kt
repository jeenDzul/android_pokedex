package com.example.pokedex.view.pokemonDetail

import androidx.lifecycle.*
import com.example.pokedex.model.PokemonDetailResponse
import com.example.pokedex.model.PokemonSpecieResponse
import com.example.pokedex.view.ScreenState
import kotlinx.coroutines.launch
import java.lang.Exception


class PokemonDetailViewModel (private val pokemonId: String,  private val findItemsInteractor: FindPokemonDetailInteractor): ViewModel() {

    private lateinit var _mainState: MutableLiveData<ScreenState<PokemonDetailState>>
    val mainState: LiveData<ScreenState<PokemonDetailState>>
        get() {
            if (!::_mainState.isInitialized) {
                _mainState = MutableLiveData()
                _mainState.value = ScreenState.Loading
                loadPokemonDetail(pokemonId)
                loadPokemonSpecie(pokemonId)
            }
            return _mainState
        }

    private fun onItemsLoaded(item: PokemonDetailResponse) {
        _mainState.value = ScreenState.Render(PokemonDetailState.ShowDetail(item))
    }


    private fun onPokemonSpecieLoaded(item: PokemonSpecieResponse) {
        _mainState.value = ScreenState.Render(PokemonDetailState.ShowSpecie(item))
    }


    fun loadPokemonDetail(pokemonId: String) {
        viewModelScope.launch {
            try {
                findItemsInteractor.findPokemonDetail(pokemonId, ::onItemsLoaded)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun loadPokemonSpecie(pokemonId: String) {
        viewModelScope.launch {
            try {
                findItemsInteractor.findPokemonSpecie(pokemonId, ::onPokemonSpecieLoaded)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}

class PokemonDetailViewModelFactory(private val pokemonId: String, private val findItemsInteractor: FindPokemonDetailInteractor) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonDetailViewModel(pokemonId, findItemsInteractor) as T
    }
}