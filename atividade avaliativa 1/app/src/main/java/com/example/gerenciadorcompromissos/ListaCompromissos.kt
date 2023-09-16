package com.example.gerenciadorcompromissos

import android.content.Context
import com.example.gerenciadorcompromissos.Utils.Companion.CHAVE_COMPROMISSO
import com.example.gerenciadorcompromissos.Utils.Companion.PREF_NAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListaCompromissos private constructor() {

    companion object {

        private var listaCompromissos = mutableListOf<Compromisso>()


        private lateinit var context: Context
        private val sharedPreferences by lazy {
            context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        }

        fun initialize(context: Context) {
            this.context = context
            listaCompromissos = carregarListaCompromissos()
        }

        fun addCompromisso(compromisso: Compromisso) {
            listaCompromissos.add(compromisso)
            salvarListaCompromissos(listaCompromissos)
        }

        fun removeComnpromisso(position: Int) {
            listaCompromissos.removeAt(position)
            salvarListaCompromissos(listaCompromissos)
        }

        fun getCompromisso(position: Int): Compromisso {
            return listaCompromissos[position]
        }

        fun getListSize(): Int {
            return listaCompromissos.size
        }

        private fun carregarListaCompromissos(): MutableList<Compromisso> {
            val tasksJson = sharedPreferences.getString(CHAVE_COMPROMISSO, null)
            return if (tasksJson != null) {
                Gson().fromJson(tasksJson, object : TypeToken<List<Compromisso>>() {}.type)
            } else {
                mutableListOf()
            }
        }

        private fun salvarListaCompromissos(tasks: MutableList<Compromisso>) {
            val tasksJson = Gson().toJson(tasks)
            sharedPreferences.edit().putString(CHAVE_COMPROMISSO, tasksJson).apply()
        }

    }
}