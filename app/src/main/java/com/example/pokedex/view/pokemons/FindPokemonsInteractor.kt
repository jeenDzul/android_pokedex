package com.example.pokedex.view.pokemons

import com.example.pokedex.model.Pokemon
import com.example.pokedex.service.repository.PokemonRepository


class FindPokemonsInteractor constructor(
     private val pokemonsRepository: PokemonRepository
) {
    suspend fun findItems(callback: (List<Pokemon>) -> Unit) {
          callback(createArrayList())
     }

    suspend fun createArrayList(): List<Pokemon> = pokemonsRepository.getPokemons()
}