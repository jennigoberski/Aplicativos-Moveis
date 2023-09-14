package com.example.aula11

class ItemData {
    companion object ItemData{
        var listaItens = mutableListOf<Item>()

        init {
            // adicionar itens iniciais na lista
            listaItens.add(Item("Arroz", 2))
            listaItens.add(Item("Bolacha", 3))
            listaItens.add(Item("Leite", 1))
        }

        fun adicionarItem(item: Item){
            listaItens.add(item)
        }

        fun getTamanhoLista() : Int {
            return listaItens.size
        }
    }
}