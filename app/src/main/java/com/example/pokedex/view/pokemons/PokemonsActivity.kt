package com.example.pokedex.view.pokemons

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex.R
import com.example.pokedex.model.Pokemon
import com.example.pokedex.service.repository.PokemonRepository
import com.example.pokedex.view.ScreenState
import com.example.pokedex.view.pokemonDetail.PokemonDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class PokemonsActivity : AppCompatActivity() {

    @Inject
    lateinit var pokemonRepository: PokemonRepository

    private val viewModel: PokemonViewModel by viewModels {
        MainViewModelFactory(FindPokemonsInteractor(
        pokemonRepository
        ))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.mainState.observe(::getLifecycle, ::updateUI)
    }

    private fun updateUI(screenState: ScreenState<PokemonState>?) {
        when (screenState) {
            ScreenState.Loading -> showProgress()
            is ScreenState.Render -> processRenderState(screenState.renderState)
        }
    }

    private fun processRenderState(renderState: PokemonState) {
        hideProgress()
        when (renderState) {
            is PokemonState.ShowItems -> setItems(renderState.items)
            is PokemonState.ClickItem -> showDetailView(renderState.id)
        }
    }

    private fun showProgress() {
        progress.visibility = View.VISIBLE
        list.visibility = View.GONE
    }

    private fun hideProgress() {
        progress.visibility = View.GONE
        list.visibility = View.VISIBLE
    }

    private fun setItems(items: List<Pokemon>) {
        list.adapter = PokemonsAdapter(items, viewModel::onItemClicked)
    }

    private fun showDetailView (pokemonId: String) {
        val postDetailActivity = Intent(this, PokemonDetailActivity::class.java)
        postDetailActivity.putExtra("pokemonId", pokemonId)
        startActivity(Intent(postDetailActivity))
    }

    /*private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        startActivity(Intent(this, PokemonsActivity::class.java))
    }*/
}
