package com.example.pokedex.view.pokemonDetail

import com.example.pokedex.model.PokemonDetailResponse
import com.example.pokedex.model.PokemonSpecieResponse

sealed class PokemonDetailState {
    class ShowDetail(val pokemonDetail: PokemonDetailResponse) : PokemonDetailState()
    class ShowSpecie(val pokemonSpecie: PokemonSpecieResponse) : PokemonDetailState()
}

