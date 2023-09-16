package com.example.gerenciadorcompromissos.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gerenciadorcompromissos.DadosLogin
import com.example.gerenciadorcompromissos.Utils
import com.example.gerenciadorcompromissos.databinding.ActivityPrimeiroAcessoBinding

class PrimeiroAcessoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrimeiroAcessoBinding
    private lateinit var loginCredentials: DadosLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPrimeiroAcessoBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        loginCredentials = DadosLogin(this)

        binding.btnCadastrar.setOnClickListener {
            validarCadastro()
        }

    }

    private fun validarCadastro() {

        if (verificarCamposEmBranco()) {
            Utils.exibirToast(this, "Preencha todos os campos!")
            return
        }

        if (verificarSenhasDiferentes()) {
            Utils.exibirToast(this, "Os campos de senha não conferem!")
            binding.edtNovaSenha.text.clear()
            binding.edtConfirmarSenha.text.clear()
            return
        }

        salvarDadosLogin()

    }

    private fun verificarCamposEmBranco(): Boolean {
        return binding.edtNovoEmail.text.isEmpty() ||
                binding.edtNovaSenha.text.isEmpty() ||
                binding.edtConfirmarSenha.text.isEmpty()
    }

    private fun verificarSenhasDiferentes(): Boolean {
        return binding.edtNovaSenha.text.toString() !=
                binding.edtConfirmarSenha.text.toString()
    }

    private fun salvarDadosLogin() {
        // salva dados de email e senha
        loginCredentials.salvarDadosLogin(
            binding.edtNovoEmail.text.toString(),
            binding.edtNovaSenha.text.toString()
        )
        Utils.exibirToast(this, "Usuário cadastrado com sucesso!")
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

}