package com.example.pokedex.di

import com.example.pokedex.service.api.PokemonService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").addConverterFactory(GsonConverterFactory.create(gson))

    @Singleton
    @Provides
    fun providePokemonsService(retrofit: Retrofit.Builder): PokemonService = retrofit.build().create(PokemonService::class.java)
}