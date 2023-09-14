package com.example.aula12

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TarefaAdapter: RecyclerView.Adapter<TarefaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val layoutTarefa = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_tarefa, parent, false)
        return TarefaViewHolder(layoutTarefa)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        holder.tarefaView.text = ListaTarefas.getTarefa(position).nomeTarefa

        holder.tarefaView.setOnLongClickListener {
            ListaTarefas.removeTarefa(position)
            notifyDataSetChanged()
            true
        }

    }

    override fun getItemCount(): Int {
        return ListaTarefas.getListSize()
    }
}