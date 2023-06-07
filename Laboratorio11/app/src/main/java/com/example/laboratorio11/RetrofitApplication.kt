package com.example.laboratorio11

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.media.session.MediaSession.Token
import com.example.laboratorio11.network.retrofit.RetrofitInstance
import com.example.laboratorio11.network.service.AuthService
import com.example.laboratorio11.repository.CredentialsRepository

class RetrofitApplication : Application() {

    // Qué significa context?
    // Se supone que es para que no cualquier aplicación acceda al token
    private val prefs: SharedPreferences by lazy {
        getSharedPreferences("Retrofit", Context.MODE_PRIVATE)
    }

    private fun getAPIService() = with(RetrofitInstance) {
        setToken(getToken())
        getLoginService()
    }

    // Para qué sirven !!
    // Qué es prefs?
    fun getToken(): String = prefs.getString(USER_TOKEN, "")!!

    // se inicializa el repositorio
    val credentialsRepository: CredentialsRepository by lazy {
        CredentialsRepository(getAPIService())
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    companion object {
        const val USER_TOKEN = "user_token"
    }
}