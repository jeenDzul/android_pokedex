package com.example.pokedex.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonSpecieResponse (
    @SerializedName("flavor_text_entries")
    @Expose
    var flavorTextEntries: List<PokemonFlavorTextEntry>
        )


