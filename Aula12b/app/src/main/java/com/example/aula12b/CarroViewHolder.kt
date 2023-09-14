package com.example.aula12b

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarroViewHolder (layoutCarro: View) : RecyclerView.ViewHolder(layoutCarro) {
    var txtMarcaModelo = layoutCarro.findViewById<TextView>(R.id.txtMarcaModelo)
}