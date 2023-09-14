package com.example.aula12b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula12b.databinding.ActivityDetalhesBinding

class DetalhesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position", -1)

        if (position == -1) { finish() }

        val carro = ListaCarros.getCarro(position)

        binding.txtModelo.text = carro.modelo
        binding.txtMarca.text = carro.marca
        binding.txtCor.text = carro.cor
        binding.txtAno.text = carro.ano.toString()

        binding.btnExcluir.setOnClickListener {
            ListaCarros.removeCarro(position)
            finish()
        }

    }
}