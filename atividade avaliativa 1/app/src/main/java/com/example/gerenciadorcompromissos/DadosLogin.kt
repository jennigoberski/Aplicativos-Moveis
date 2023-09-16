package com.example.gerenciadorcompromissos

import android.content.Context
import com.example.gerenciadorcompromissos.Utils.Companion.CHAVE_EMAIL
import com.example.gerenciadorcompromissos.Utils.Companion.CHAVE_LOGADO
import com.example.gerenciadorcompromissos.Utils.Companion.CHAVE_SENHA

class DadosLogin(context: Context) {

    private var sharedPreferences = context.getSharedPreferences("Login", Context.MODE_PRIVATE)
    private val EMAIL = "email@email.com"
    private val SENHA = "senha123"

    fun salvarDadosLogin(email: String, senha: String) {
        sharedPreferences.edit()
            .putString("email", email)
            .putString("senha", senha)
            .apply()
    }

    fun getEmail(): String {
        return sharedPreferences.getString("email", EMAIL) ?: ""
    }

    fun getSenha(): String {
        return sharedPreferences.getString("senha", SENHA) ?: ""
    }

    fun limparDados() {
        sharedPreferences.edit()
            .remove(CHAVE_EMAIL)
            .remove(CHAVE_SENHA)
            .apply()
    }

    fun continuarLogado(valor: Boolean) {
        sharedPreferences.edit()
            .putBoolean(CHAVE_LOGADO, valor)
            .apply()
    }

    fun getLogado(): Boolean {
        return sharedPreferences.getBoolean(CHAVE_LOGADO, false)
    }

}