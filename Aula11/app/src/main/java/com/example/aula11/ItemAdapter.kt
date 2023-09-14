package com.example.aula11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter: RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : ItemViewHolder {

        // criar variavel para receber todos os elementos da view
        // referente ao layout da lista
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)
        // retornar um view holder criado a partir desta variael
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // criar objeto do tipo Item com base na posição atual registrada
        // pelo onBindingViewHolder
        var currentItem = ItemData.listaItens[position] // acessa a lista com base na
        // posição informada

        // insere dentro do holder de cada item da lista os valores
        // correspondentes a cada um dos objetos da lista
        holder.txtNomeView.text = currentItem.nome
        holder.txtQtdeView.text = "Quantidade: " +
                currentItem.quantidade.toString()
    }

    override fun getItemCount(): Int {
        return ItemData.listaItens.size // retorna o tamanho da lista
    }
}