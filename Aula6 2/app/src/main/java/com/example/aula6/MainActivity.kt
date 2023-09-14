package com.example.aula6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aula6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mensagem: String
    private val TAG = "ESTADO" // val = constante
    private lateinit var binding: ActivityMainBinding
    /* lembrando que: ActivityMainBinding é uma classe de apoio
    criada pelo View Binding para ajudar a buscar as referencias
    dos elementos da UI (activity_main.xml)
     */

    private lateinit var loginCredentials: LoginCredentials

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        // estamos inflando o layout presente no xml para dentro
        // do objeto binding

        loginCredentials = LoginCredentials(this)


        binding.btnExcluirDados.setOnClickListener {
            excluirDados()
        }

        binding.btnSair.setOnClickListener {
            loginCredentials.continuarLogado(false)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        setContentView(binding.root)
        Log.d(TAG, "onCreate invocado")

        var email = loginCredentials.getEmail()
        mensagem = "Hello, $email!"

    }

    override fun onStart() {
        super.onStart()
        binding.txtMensagem.text = mensagem
        Log.d (TAG, "onStart invocado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume invocado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause invocado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop invocado")
        //finish() // mata a activity atual
    }

    override fun onRestart() {
        super.onRestart()
        mensagem = "Hello again!"
        Log.d(TAG, "onRestart invocado")
    }

    private fun excluirDados() {
        loginCredentials.limparDados()

        Util.exibirToast(this, "Dados de login resetados para o padrão")
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}