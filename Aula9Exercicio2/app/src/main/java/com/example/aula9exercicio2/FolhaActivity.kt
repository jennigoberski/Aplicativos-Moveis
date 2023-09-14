package com.example.aula9exercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula9exercicio2.databinding.ActivityFolhaBinding

class FolhaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFolhaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFolhaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nome = intent.getStringExtra(Util.Chaves.NOME)
        var horasTrab = intent.getIntExtra(Util.Chaves.HORAS_TRAB, 0)
        var valorHora = intent.getFloatExtra(Util.Chaves.VALOR_HORA, 0f)

        var folha = Folha(nome.toString(), horasTrab, valorHora)

        binding.txtFolha.text = folha.toString()

        binding.btnFechar.setOnClickListener {
            finish()
        }

    }
}