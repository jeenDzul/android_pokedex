package com.example.pokedex.di

import com.example.pokedex.model.Pokemon
import com.example.pokedex.service.api.PokemonService
import com.example.pokedex.service.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePokemonRepository(
        pokemonService: PokemonService
    ): PokemonRepository = PokemonRepository(pokemonService)
}