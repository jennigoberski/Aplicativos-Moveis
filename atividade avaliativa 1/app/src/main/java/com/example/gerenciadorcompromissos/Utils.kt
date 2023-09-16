package com.example.gerenciadorcompromissos

import android.content.Context
import android.widget.Toast
import android.widget.Toast.makeText

class Utils {

    companion object {
        const val PREF_NAME = "TaskPreferences"
        const val CHAVE_COMPROMISSO = "compromisso"

        const val CHAVE_EMAIL = "email"
        const val CHAVE_SENHA = "senha"
        const val CHAVE_LOGADO = "logado"

        fun exibirToast(context: Context, msg: String) {
            makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }
}