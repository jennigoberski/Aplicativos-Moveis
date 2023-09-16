package com.example.gerenciadorcompromissos.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gerenciadorcompromissos.ListaCompromissos
import com.example.gerenciadorcompromissos.R
import com.example.gerenciadorcompromissos.Utils.Companion.exibirToast
import com.example.gerenciadorcompromissos.databinding.ActivityDetalhesBinding

class DetalhesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        binding = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position", -1)

        if (position == -1) {
            finish()
        }

        ListaCompromissos.initialize(this)

        val compromisso = ListaCompromissos.getCompromisso(position)

        binding.txtTitulo.text = compromisso.titulo
        binding.txtData.text = compromisso.data
        binding.txtHoraInicio.text = compromisso.horaInicio
        binding.txtHoraFim.text = compromisso.horaFim
        binding.txtDescricao.text = compromisso.descricao

        binding.btnExcluir.setOnClickListener {
            ListaCompromissos.removeComnpromisso(position)
            exibirToast(this, "Compromisso removido com sucesso!")

            finish()
        }
    }
}