package com.example.pokedex.view.pokemons

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.pokedex.R
import com.example.pokedex.model.Pokemon
import com.example.pokedex.util.Utils

class PokemonsAdapter(private val items: List<Pokemon>, private val listener: (String) -> Unit) :
    androidx.recyclerview.widget.RecyclerView.Adapter<PokemonsAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_main_item, parent, false) as TextView

        return MainViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item.name
        holder.textView.setOnClickListener {
            val pokemonId = Utils.getPokemonId(item.url)
            listener(pokemonId)
        }
    }

    override fun getItemCount(): Int = items.size

    class MainViewHolder(val textView: TextView) : androidx.recyclerview.widget.RecyclerView.ViewHolder(textView) {

    }
}