package com.example.aula3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // referencia dos componentes de interface
        var edtNome = findViewById<EditText>(R.id.edtNome)
        var btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        var btnAbrir = findViewById<Button>(R.id.btnAbrir)

        // criar um evento de click do botao
        btnCadastrar.setOnClickListener {

            // validar se o campo nao está vazio
            if (!edtNome.text.isEmpty()) {

                // copiar o valor do campo para uma var local
                var nome = edtNome.text.toString()

                // mostrar toast com o nome informado
                Toast.makeText(applicationContext, "Nome cadastrado: $nome", Toast.LENGTH_SHORT).show()

                // limpar edtNome
                edtNome.text.clear()
                Log.d("TESTE", "NOME: $nome")

            } else {
                Toast.makeText(applicationContext, "Nome não pode estar em branco", Toast.LENGTH_SHORT).show()

            }

        }

        btnAbrir.setOnClickListener {
            // criar uma nova intent
            var intent = Intent(this,NewActivity::class.java )
            // iniciar nova activity
            startActivity(intent)
        }

    }
}