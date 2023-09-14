package com.example.aula6

import android.content.Context
import android.content.SharedPreferences

class LoginCredentials(context: Context){

    // Classe criada com o objetivo de gerenciar e armazenar dados de login
    // O contrutor da classe (parenteses acima) precisa receber um Context como paramentro para poder
    // aplicar para o sharedPreferences
    private var sharedPreferences  =
        context.getSharedPreferences("Login", Context.MODE_PRIVATE)

    // função que recebe email e senha para armazenar no shared preferences
    fun salvarDados(email : String, senha : String) {
        sharedPreferences.edit()
            .putString(Util.CHAVE_EMAIL, email)
            .putString(Util.CHAVE_SENHA, senha)
            .apply()
    }

    // função para retornar email salvo no shared preferences
    fun getEmail() : String {
        return sharedPreferences.getString(Util.CHAVE_EMAIL, Util.EMAIL_PADRAO) ?: ""
        // ?: é chamado "elvis operator" em Kotlin
        // Este operador previne retorno nulo (retornando uma stirng em branca no lugar),
        // no caso da instância de sharedPreferences ser nula no momento em que esta função é chamada.
    }

    // retorna senha salva no sahred preferences
    fun getSenha() : String {
        return sharedPreferences.getString(Util.CHAVE_SENHA, Util.SENHA_PADRAO) ?: ""
    }

    // limpa dados armazenados nas chaves "email" e "senha"
    fun limparDados() {
        sharedPreferences.edit()
            .remove(Util.CHAVE_EMAIL)
            .remove(Util.CHAVE_SENHA)
            .apply()
    }

    fun continuarLogado(valor : Boolean) {
        sharedPreferences.edit()
            .putBoolean(Util.CHAVE_LOGADO, valor)
            .apply()
    }

    fun getLogado() : Boolean {
        return sharedPreferences.getBoolean(Util.CHAVE_LOGADO, false)
    }


}