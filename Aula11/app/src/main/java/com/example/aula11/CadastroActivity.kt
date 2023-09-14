package com.example.aula11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aula11.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSalvar.setOnClickListener {
            validarDados()
        }
    }

    fun validarDados(){

        if (binding.edtNome.text.isEmpty() || binding.edtQtde.text.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            return
        }

        var nome = binding.edtNome.text.toString()
        var qtde = binding.edtQtde.text.toString().toInt()

        ItemData.adicionarItem(Item(nome, qtde))
        finish()

    }
}