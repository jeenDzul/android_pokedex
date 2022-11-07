package com.example.pokedex.view.pokemonDetail

import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonDetailResponse
import com.example.pokedex.model.PokemonSpecieResponse
import com.example.pokedex.service.repository.PokemonRepository

class FindPokemonDetailInteractor constructor(
    private val pokemonsRepository: PokemonRepository
) {
    suspend fun findPokemonDetail(pokemonId: String,  callback: (PokemonDetailResponse) -> Unit) {
        callback(getDetailResponse(pokemonId))
    }

    suspend fun findPokemonSpecie(pokemonId: String,  callback: (PokemonSpecieResponse) -> Unit) {
        callback(getSpecieResponse(pokemonId))
    }
    suspend fun getDetailResponse(id: String): PokemonDetailResponse = pokemonsRepository.getPokemonDetail(id)
    suspend fun getSpecieResponse(id: String): PokemonSpecieResponse = pokemonsRepository.getPokemonSpecie(id)

}