package com.example.gerenciadorcompromissos

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gerenciadorcompromissos.activities.DetalhesActivity

class CompromissoAdapter(var context: Context) : RecyclerView.Adapter<CompromissoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompromissoViewHolder {
        val layoutCompromisso =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_compromisso, parent, false)
        return CompromissoViewHolder(layoutCompromisso)
    }

    override fun onBindViewHolder(holder: CompromissoViewHolder, position: Int) {
        val compromisso = ListaCompromissos.getCompromisso(position)
        holder.txtCompromissoVisualizacao.text =
            "O que: ${compromisso.titulo} | Quando: ${compromisso.data}"

        holder.txtCompromissoVisualizacao.setOnLongClickListener {
            var intent = Intent(context, DetalhesActivity::class.java)
            intent.putExtra("position", position)
            context.startActivity(intent)
            true
        }
    }

    override fun getItemCount(): Int {
        ListaCompromissos.initialize(context)
        return ListaCompromissos.getListSize()
    }
}
