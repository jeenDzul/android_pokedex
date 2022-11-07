package com.example.pokedex.view.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.activity.viewModels
import com.example.pokedex.R
import com.example.pokedex.view.ScreenState
import com.example.pokedex.view.pokemons.PokemonsActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity()  {

    private val viewModel: LoginViewModel by viewModels { LoginViewModelFactory(LoginInteractor())}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel.loginState.observe(::getLifecycle, ::updateUI)

        button.setOnClickListener { onLoginClicked() }
    }

    private fun updateUI(screenState: ScreenState<LoginState>?) {
        when (screenState) {
            ScreenState.Loading -> progress.visibility = View.VISIBLE
            is ScreenState.Render -> processLoginState(screenState.renderState)
        }
    }

    private fun processLoginState(renderState: LoginState) {
        progress.visibility = View.GONE
        when (renderState) {
            LoginState.Success -> successLogin()
            LoginState.WrongUserName -> username.error = getString(R.string.username_error)
            LoginState.WrongPassword -> password.error = getString(R.string.password_error)
        }
    }

    private fun successLogin () {
        startActivity(Intent(this, PokemonsActivity::class.java))
    }

    private fun onLoginClicked() {
        viewModel.onLoginClicked(username.text.toString(), password.text.toString())
    }
}