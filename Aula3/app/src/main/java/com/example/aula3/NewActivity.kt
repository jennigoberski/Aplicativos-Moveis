package com.example.aula3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.aula3.databinding.ActivityNewBinding

class NewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inicializar o binding
        binding = ActivityNewBinding.inflate(layoutInflater)
        // criar variavel "view" que receberá a root da activity
        // ou seja, todos os elementos de view presentes dentro dela
        var view = binding.root

        // setamos a view, que contem o binding te todos os elementos
        // de interface, como sendo o "content view" de nossa classe
        setContentView(view)

        var mensagem = "Teste de mensagem"

        // acessando componentes da maneira "antiga":
        //var txtMensagem = findViewById<TextView>(R.id.txtMensagem)
        // txtMensagem.text = mensagem

        // acessando componentes com View Binding
        binding.txtMensagem.text = mensagem
        binding.txtMensagem2.text = "Mensagem setada via código - de novo!"


    }
}