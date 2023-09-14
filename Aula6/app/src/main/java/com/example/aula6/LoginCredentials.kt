package com.example.aula6

import android.content.Context
import android.content.SharedPreferences

class LoginCredentials(context: Context){

    // Classe criada com o objetivo de gerenciar e armazenar dados de login
    // O contrutor da classe (parenteses acima) precisa receber um Context como paramentro para poder
    // aplicar para o sharedPreferences
    private var sharedPreferences : SharedPreferences =
        context.getSharedPreferences("Login", Context.MODE_PRIVATE)

    // valores fixos (padrão) para dados do login
    private val EMAIL = "jasobreiro@up.edu.br"
    private val SENHA = "lalala123"

    // funçào qwue recebe email e senha para armazenar no shared preferences
    fun salvarDados(email : String, senha : String) {
        sharedPreferences.edit()
            .putString("email", email)
            .putString("senha", senha)
            .apply()
    }

    // funçào para retornar email salvo no chared preferences
    fun getEmail() : String {
        return sharedPreferences.getString("email", EMAIL) ?: ""
        // ?: é chamado "elvis operator" em Kotlin
        // Este operador previne retorno nulo (retornando uma stirng em branca no lugar),
        // no caso da instância de sharedPreferences ser nula no momento em que esta função é chamada.
    }

    // retorna senha salva no sahred preferences
    fun getSenha() : String {
        return sharedPreferences.getString("senha", SENHA) ?: ""
    }

    // limpa dados armazenados nas chaves "email" e "senha"
    fun limparDados() {
        sharedPreferences.edit()
            .remove("email")
            .remove("senha")
            .apply()
    }


}