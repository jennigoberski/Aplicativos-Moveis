package com.example.gerenciadorcompromissos.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gerenciadorcompromissos.Compromisso
import com.example.gerenciadorcompromissos.ListaCompromissos
import com.example.gerenciadorcompromissos.Utils.Companion.exibirToast
import com.example.gerenciadorcompromissos.databinding.ActivityAdicionarCompromissoBinding

class AdicionarCompromissoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdicionarCompromissoBinding

    private lateinit var titulo: String
    private lateinit var data: String
    private lateinit var horaInicio: String
    private lateinit var horaFim: String
    private lateinit var descricao: String

    private lateinit var compromisso: Compromisso

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdicionarCompromissoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSalvar.setOnClickListener {
            preencherCampos()

            if (verificarCamposPreenchidos()) {
                compromisso = Compromisso(titulo, data, horaInicio, horaFim, descricao)
                ListaCompromissos.initialize(this)
                ListaCompromissos.addCompromisso(compromisso)

                exibirToast(this, "Compromisso adicionado com sucesso!")
                finish()
            } else {
                exibirToast(this, "Preencha todos os campos!")
                limparCampos()
            }
        }

    }

    private fun preencherCampos() {
        titulo = binding.edtTitulo.text.toString()
        data = binding.edtData.text.toString()
        horaInicio = binding.edtHoraInicio.text.toString()
        horaFim = binding.edtHoraFim.text.toString()
        descricao = binding.edtDescricao.text.toString()
    }

    private fun verificarCamposPreenchidos(): Boolean {
        return titulo.isNotEmpty()
                && data.isNotEmpty()
                && horaInicio.isNotEmpty()
                && horaFim.isNotEmpty()
                && descricao.isNotEmpty()
    }

    private fun limparCampos() {
        binding.edtTitulo.text.clear()
        binding.edtData.text.clear()
        binding.edtHoraInicio.text.clear()
        binding.edtHoraFim.text.clear()
        binding.edtDescricao.text.clear()
    }
}