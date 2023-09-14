package com.example.aula12

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarefaViewHolder (layoutTarefa : View) : RecyclerView.ViewHolder(layoutTarefa) {
    var tarefaView = layoutTarefa.findViewById<TextView>(R.id.txtTarefa)
}