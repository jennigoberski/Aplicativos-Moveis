package com.example.aula12b

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CarroAdapter (var context: Context): RecyclerView.Adapter<CarroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroViewHolder {
       val layoutCarro = LayoutInflater.from(parent.context)
           .inflate(R.layout.layout_carro, parent, false)
        return CarroViewHolder(layoutCarro)
    }

    override fun onBindViewHolder(holder: CarroViewHolder, position: Int) {
        val carro = ListaCarros.getCarro(position)
        holder.txtMarcaModelo.text = "${carro.marca} (${carro.modelo})"

        holder.txtMarcaModelo.setOnLongClickListener {
            // enviar a posição do elemento atual para a DetalhesActivity
            var intent = Intent(context, DetalhesActivity::class.java)
            intent.putExtra("position", position)
            context.startActivity(intent)
            true
        }

    }

    override fun getItemCount(): Int {
       return ListaCarros.getListSize()
    }
}