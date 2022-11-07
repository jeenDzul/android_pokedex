package com.example.pokedex.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

data class Pokemon (
    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("url")
    @Expose
    var url: String
)
