package com.example.gerenciadorcompromissos.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gerenciadorcompromissos.DadosLogin
import com.example.gerenciadorcompromissos.Utils.Companion.exibirToast
import com.example.gerenciadorcompromissos.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var dadosLogin: DadosLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        dadosLogin = DadosLogin(this)

        binding.btnEntrar.setOnClickListener {
            validarCampos()
        }

        binding.btnPrimeiroAcesso.setOnClickListener {
            startActivity(Intent(this, PrimeiroAcessoActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()

        if (dadosLogin.getLogado()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

    private fun validarCampos() {

        if (binding.edtEmail.text.isEmpty() ||
            binding.edtSenha.text.isEmpty()
        ) {
            exibirToast(this, "Preencha todos os campos!")
            return
        }

        var email = binding.edtEmail.text.toString()
        var senha = binding.edtSenha.text.toString()

        var sharedEmail = dadosLogin.getEmail()
        var sharedSenha = dadosLogin.getSenha()

        var valoresDiferentes = email != sharedEmail || senha != sharedSenha

        if (valoresDiferentes) {
            exibirToast(this, "E-mail ou Senha inválidos!")

            binding.edtEmail.text.clear()
            binding.edtSenha.text.clear()

            return
        }

        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}