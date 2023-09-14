package com.example.aula6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aula6.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    // criar objeto de login credentials
    private lateinit var loginCredentials: LoginCredentials

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        var view = binding.root

        setContentView(view)

        // Nova instancia de login credentials:
        loginCredentials = LoginCredentials(this)

        // ação de clique do botão btnEntrar
        binding.btnEntrar.setOnClickListener {
            validarLogin()
        }

        // ação de clique do bot"ao btnPrimeiroAcesso
        binding.btnPrimeiroAcesso.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()

        if (loginCredentials.getLogado()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

    private fun validarLogin() {


        // validações padrão de dados, como visto nas aulas passadas:
        if (verificarCamposEmBranco()) {
            // mensagem de erro
            Util.exibirToast(this, "Preencha todos os campos!")
            return
        }

        // compara se dados digitados são diferentes aos armazenados
        if (validarDadosLogin()) {
            Util.exibirToast(this, "E-mail ou senha inválidos!")
            binding.edtEmail.text.clear()
            binding.edtSenha.text.clear()
            return
        }

        loginCredentials.continuarLogado(binding.ckbContinuarLogado.isChecked)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun verificarCamposEmBranco() : Boolean {
        return binding.edtEmail.text.isEmpty() ||
                binding.edtSenha.text.isEmpty()
    }

    private fun validarDadosLogin() : Boolean {
        return binding.edtEmail.text.toString() != loginCredentials.getEmail() ||
                binding.edtSenha.text.toString() != loginCredentials.getSenha()
    }




}