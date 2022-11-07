package com.example.pokedex.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PokemonFlavorTextEntry(
    @SerializedName("flavor_text")
    @Expose
    var flavorText: String,
    @SerializedName("language")
    @Expose
    var language: Language
)

data class Language(
    @SerializedName("name")
    @Expose
    var name: String
)