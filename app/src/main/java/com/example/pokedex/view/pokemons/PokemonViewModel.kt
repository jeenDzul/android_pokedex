package com.example.pokedex.view.pokemons

import androidx.lifecycle.*
import com.example.pokedex.model.Pokemon
import com.example.pokedex.view.ScreenState
import kotlinx.coroutines.launch
import java.lang.Exception


class PokemonViewModel(private val findItemsInteractor: FindPokemonsInteractor) : ViewModel() {

    private lateinit var _mainState: MutableLiveData<ScreenState<PokemonState>>

    val mainState: LiveData<ScreenState<PokemonState>>
       get() {
            if (!::_mainState.isInitialized) {
                _mainState = MutableLiveData()
                _mainState.value = ScreenState.Loading
                loadPokemons()
            }
            return _mainState
        }

    private fun onItemsLoaded(items: List<Pokemon>) {
        _mainState.value = ScreenState.Render(PokemonState.ShowItems(items))
    }


    fun loadPokemons() {
        viewModelScope.launch {
            try {
                findItemsInteractor.findItems(::onItemsLoaded)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun onItemClicked(item: String) {
        _mainState.value = ScreenState.Render(PokemonState.ClickItem(item))
    }
}

class MainViewModelFactory(private val findItemsInteractor: FindPokemonsInteractor) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonViewModel(findItemsInteractor) as T
    }
}