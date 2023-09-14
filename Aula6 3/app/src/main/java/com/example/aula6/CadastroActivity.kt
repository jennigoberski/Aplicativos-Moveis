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

        if (verificarCamposEmBranco()) {
            Util.exibirToast(this,"Preencha todos os campos!")
            return
        }

        if (verificarSenhasDiferentes()) {
            Util.exibirToast(this, "Os campos de senha não conferem!")
            binding.edtNovaSenha.text.clear()
            binding.edtConfirmarSenha.text.clear()
            return
        }

       salvarDadosLogin()

    }

    private fun verificarCamposEmBranco() : Boolean {
        return binding.edtNovoEmail.text.isEmpty() ||
                binding.edtNovaSenha.text.isEmpty() ||
                binding.edtConfirmarSenha.text.isEmpty()
    }

    private fun verificarSenhasDiferentes() : Boolean {
        return binding.edtNovaSenha.text.toString() !=
                binding.edtConfirmarSenha.text.toString()
    }

    private fun salvarDadosLogin() {
        // salva dados de email e senha
        loginCredentials.salvarDados(
            binding.edtNovoEmail.text.toString(),
            binding.edtNovaSenha.text.toString()
            )
        Util.exibirToast(this,"Usuário cadastrado com sucesso!")
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

}