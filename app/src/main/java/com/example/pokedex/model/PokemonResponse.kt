package com.example.pokedex.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonResponse (
    @SerializedName("name")
    @Expose
    var count: Int,

    @SerializedName("next")
    @Expose
    var next: String,

    @SerializedName("previous")
    @Expose
    var previous: String,

    @SerializedName("results")
    @Expose
    var results: List<Pokemon>,

    )