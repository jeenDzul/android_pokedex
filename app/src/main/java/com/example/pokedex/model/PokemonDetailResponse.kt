package com.example.pokedex.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonDetailResponse (
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("sprites")
    @Expose
    var sprites: PokemonSprite
        )