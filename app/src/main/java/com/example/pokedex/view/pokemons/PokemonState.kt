package com.example.pokedex.view.pokemons

import com.example.pokedex.model.Pokemon


sealed class PokemonState {
    class ShowItems(val items: List<Pokemon>) : PokemonState()
    class ClickItem(val id: String) : PokemonState()

}