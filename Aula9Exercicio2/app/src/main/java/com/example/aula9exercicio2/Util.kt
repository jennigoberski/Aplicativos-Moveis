package com.example.aula9exercicio2

import android.content.Context
import android.widget.Toast

class Util private constructor() {

    companion object {

        fun exibirToast(context: Context, msg: String){
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

    object Chaves {
        const val NOME = "nome"
        const val HORAS_TRAB = "horasTrab"
        const val VALOR_HORA = "valorHora"
    }

}