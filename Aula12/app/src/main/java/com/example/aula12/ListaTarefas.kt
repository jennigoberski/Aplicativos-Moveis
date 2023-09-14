package com.example.aula12

class ListaTarefas private constructor(){

    companion object {

        private var listaTarefas = mutableListOf<Tarefa>()

        init {
            listaTarefas.add(Tarefa("Fazer compras da semana"))
            listaTarefas.add(Tarefa("Abaster carro"))
            listaTarefas.add(Tarefa("Passear com os cachorros"))
        }

        fun addTarefa(tarefa: Tarefa){
            listaTarefas.add(tarefa)
        }

        fun getTarefa(position: Int) : Tarefa {
            return listaTarefas[position]
        }

        fun removeTarefa(position: Int){
            listaTarefas.removeAt(position)
        }

        fun getListSize(): Int {
            return listaTarefas.size
        }

    }
}