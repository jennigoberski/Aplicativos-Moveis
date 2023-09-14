package com.example.aula9exercicio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula9exercicio2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            validarDados()
        }
    }

    private fun validarDados(){

        if (binding.edtNome.text.isEmpty() ||
                binding.edtHorasTrab.text.isEmpty() ||
                binding.edtValorHora.text.isEmpty()) {
            // exibir toast
            Util.exibirToast(this, "Preencha todos os campos")
            return
        }

        if (binding.edtHorasTrab.text.toString().toInt() <= 0 ||
                binding.edtValorHora.text.toString().toFloat() <= 0){
            // exibir toast
            Util.exibirToast(this, "Valores não podem ser zero")
            return
        }

        var intent = Intent(this, FolhaActivity::class.java)

        var nome = binding.edtNome.text.toString()
        var horasTrab = binding.edtHorasTrab.text.toString().toInt()
        var valorHora = binding.edtValorHora.text.toString().toFloat()

        intent.putExtra(Util.Chaves.NOME, nome)
        intent.putExtra(Util.Chaves.HORAS_TRAB, horasTrab)
        intent.putExtra(Util.Chaves.VALOR_HORA, valorHora)

        binding.edtNome.text.clear()
        binding.edtHorasTrab.text.clear()
        binding.edtValorHora.text.clear()

        startActivity(intent)

    }
}