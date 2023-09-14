package com.example.recipebook

import android.content.Context
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText

class Utils {

    companion object {
        const val CHAVE_SHARED_PREFERENCES = "receita_shared_preferences"
        const val MODE = Context.MODE_PRIVATE

        fun criarToast(context: Context, mensagem: String) {
            makeText(context, mensagem, LENGTH_LONG).show()
        }

    }
}

