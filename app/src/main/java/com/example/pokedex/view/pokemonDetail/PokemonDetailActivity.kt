package com.example.pokedex.view.pokemonDetail

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonDetailResponse
import com.example.pokedex.model.PokemonSpecieResponse
import com.example.pokedex.service.repository.PokemonRepository
import com.example.pokedex.util.Utils
import com.example.pokedex.view.ScreenState

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_pokemon_detail.*
import javax.inject.Inject

@AndroidEntryPoint
class PokemonDetailActivity : AppCompatActivity()  {

    @Inject
    lateinit var pokemonRepository: PokemonRepository

    private val viewModel: PokemonDetailViewModel by viewModels {
        PokemonDetailViewModelFactory(
            intent.getStringExtra("pokemonId").toString(),
            FindPokemonDetailInteractor(
            pokemonRepository
        )
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        viewModel.mainState.observe(::getLifecycle, ::updateUI)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun updateUI(screenState: ScreenState<PokemonDetailState>?) {
        when (screenState) {
            is ScreenState.Render -> processRenderState(screenState.renderState)
        }
    }

    private fun processRenderState(renderState: PokemonDetailState) {
        when (renderState) {
            is PokemonDetailState.ShowDetail -> setItem(renderState.pokemonDetail)
            is PokemonDetailState.ShowSpecie -> setSpecie(renderState.pokemonSpecie)
        }
    }

    private fun setItem(item: PokemonDetailResponse) {
        Glide.with(this).load(item.sprites.other.home.frontDefault).into(detail_img)
        Glide.with(this).load(item.sprites.backDefault).into(detail_user_img)

        detail_title.text = item.name
        detail_date_name.text = Utils.getCurrentDateTime() + " | "
    }


    private fun setSpecie(item: PokemonSpecieResponse) {
        val sizeListFlavorText = item.flavorTextEntries.filter { it -> it.language.name == "es" }
        val randomIndex = (0..sizeListFlavorText.size).random()
        detail_desc.text = sizeListFlavorText[randomIndex].flavorText
    }







}