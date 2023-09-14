package com.example.aula6

import android.content.Context
import android.widget.Toast

class Util {
    // Classe para agregar métodos úteis que possam ser utilziadas em outras classes

    // kotlin não trabalha com métodos e atributos estáticos. No lugar, usamos o "companion object"
    // Assim, conseguimos invocar o método abaixo do mesmo jeito que fariámos em java:
    // Classe.metodo(). No caso do método abaixo: Util.exibirToast()

    companion object {

        val CHAVE_EMAIL = "email"
        val CHAVE_SENHA  = "senha"
        val CHAVE_LOGADO = "logado"
        val EMAIL_PADRAO = "jasobreiro@up.edu.br"
        val SENHA_PADRAO = "lalala123"

        // exibe um toast com base no contexto e string recebidos via parametro
        fun exibirToast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

}