package com.example.aula4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.aula4.databinding.ActivityNewBinding

class NewActivity : AppCompatActivity() {

    // criar uma instancia para o view binding
    private lateinit var binding: ActivityNewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inlar layout xml para dentro de 'binding'
        binding = ActivityNewBinding.inflate(layoutInflater)

        // facilitar o acesso ao root (a toda a camada view) do binding
        var view = binding.root // root = o layout principal do seu xml

        // setar este view como sendo o novo layout para esta classe
        setContentView(view)

        // ação de clique bo botão btnCadastrarUsuario
        binding.btnCadastrarUsuario.setOnClickListener {

            var mensagem = ""

            if (validarCamposVazios()) {
                mensagem = "Preencha todos os campos"
            } else {
                mensagem = "Usuario cadastrado"
                binding.edtEmail.text.clear()
                binding.edtSenha.text.clear()
            }

            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
        }
    }

    private fun validarCamposVazios() : Boolean {
        return binding.edtEmail.text.isEmpty() || binding.edtSenha.text.isEmpty()
    }
}