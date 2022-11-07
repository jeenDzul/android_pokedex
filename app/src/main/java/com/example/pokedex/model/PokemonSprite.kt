package com.example.pokedex.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonSprite (
    @SerializedName("back_default")
    @Expose
    var backDefault: String,

    @SerializedName("other")
    @Expose
    var other: Other
    )

data class Other (
    @SerializedName("home")
    @Expose
    var home: Home
        )

data class Home (
    @SerializedName("front_default")
    @Expose
    var frontDefault: String
        )