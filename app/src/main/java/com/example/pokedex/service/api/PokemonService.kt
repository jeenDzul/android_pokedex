package com.example.pokedex.service.api

import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonDetailResponse
import com.example.pokedex.model.PokemonResponse
import com.example.pokedex.model.PokemonSpecieResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
        @GET("pokemon/")
        suspend fun getPokemons(): PokemonResponse

        @GET("pokemon/{id}/")
        suspend fun getPokemon(@Path("id") id: String): PokemonDetailResponse


    @GET("pokemon-species/{id}/")
    suspend fun getPokemonSpecie(@Path("id") id: String): PokemonSpecieResponse
    }
