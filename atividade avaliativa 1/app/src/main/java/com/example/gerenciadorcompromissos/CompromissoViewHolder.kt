package com.example.gerenciadorcompromissos

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CompromissoViewHolder(layoutCompromisso: View) : RecyclerView.ViewHolder(layoutCompromisso) {
    var txtCompromissoVisualizacao =
        layoutCompromisso.findViewById<TextView>(R.id.txtCompromissoVisualizacao)
}