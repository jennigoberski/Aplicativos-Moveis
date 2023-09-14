package com.example.aula12b

class ListaCarros private constructor(){

    companion object {

        private var listaCarros = mutableListOf<Carro>()

        init {
            listaCarros.add(Carro("Nissan", "Versa", "Preto", 2017))
            listaCarros.add(Carro("Mitsubishi", "Lancer", "Vermelho", 2016))
        }

        fun addCarro(carro: Carro){
            listaCarros.add(carro)
        }

        fun getCarro(position: Int): Carro {
            return listaCarros.get(position)
        }

        fun removeCarro(position: Int){
            listaCarros.removeAt(position)
        }

        fun getListSize() : Int {
            return listaCarros.size
        }

    }

}