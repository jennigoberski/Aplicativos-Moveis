package com.example.aula6

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aula6.databinding.ActivityCadastroBinding
import kotlin.math.log


class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private lateinit var loginCredentials: LoginCredentials

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        loginCredentials = LoginCredentials(this)

        binding.btnCadastrar.setOnClickListener {
            validarCadastro()
        }

    }

    private fun validarCadastro() {

        if (binding.edtNovoEmail.text.isEmpty() ||
            binding.edtNovaSenha.text.isEmpty() ||
            binding.edtConfirmarSenha.text.isEmpty()
        ) {
            Util.exibirToast(this,"Preencha todos os campos!")
            return
        }

        var email = binding.edtNovoEmail.text.toString()
        var senha = binding.edtNovaSenha.text.toString()
        var confirmarSenha = binding.edtConfirmarSenha.text.toString()

        if (senha != confirmarSenha) {
            Util.exibirToast(this, "Os campos de senha não conferem!")
            return
        }

        // salva dados de email e senha
        loginCredentials.salvarDados(email, senha)

        Util.exibirToast(this,"Usuário cadastrado com sucesso!")

        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

    }


}