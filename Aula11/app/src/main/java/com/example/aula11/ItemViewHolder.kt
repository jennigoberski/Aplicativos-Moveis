package com.example.aula11

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ItemViewHolder (itemView: View) : ViewHolder (itemView){
    var txtNomeView: TextView = itemView.findViewById(R.id.txtNome)
    var txtQtdeView: TextView = itemView.findViewById(R.id.txtQtde)
}