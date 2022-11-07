package com.example.pokedex.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.regex.Pattern

class Utils {
    companion object {
        fun getPokemonId(url: String): String {
            val delim = "/"
            val positionPokemonId = 6;
            val urlArray = Pattern.compile(delim).split(url)
            val currentPokemonId = urlArray[positionPokemonId];
            return currentPokemonId;
        }

        fun getCurrentDateTime(): String {
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            return currentDate
        }
    }
}