package com.example.pokedex.service.repository

import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonDetailResponse
import com.example.pokedex.model.PokemonSpecieResponse
import com.example.pokedex.service.api.PokemonService
import javax.inject.Inject

class PokemonRepository @Inject constructor (
    private val pokemonService: PokemonService
    ) {
    suspend fun getPokemons(): List<Pokemon> = pokemonService.getPokemons().results
    suspend fun getPokemonDetail(id: String): PokemonDetailResponse = pokemonService.getPokemon(id)
    suspend fun getPokemonSpecie(id: String): PokemonSpecieResponse = pokemonService.getPokemonSpecie(id)
}