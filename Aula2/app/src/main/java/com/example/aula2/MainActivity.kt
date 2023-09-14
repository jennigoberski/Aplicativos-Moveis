package com.example.aula2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // declaração variáveis
        // int idade = 36; == java
        // var idade: Int = 36 // kotlin
        // var idade = 36
        // var nome = "Jason Sobreiro"

        // buscar a ref do componente que quero acessar
        // para acessar o TextView txtMensagem:
        var txtMensagem = findViewById<TextView>(R.id.txtMensagem)
        var edtNome = findViewById<EditText>(R.id.edtNome)
        var edtIdade = findViewById<EditText>(R.id.edtIdade)
        var btnEnviar = findViewById<Button>(R.id.btnEnviar)

        // setar um novo texto para o componente
        //txtMensagem.text = "Meu nome é $nome, e eu tenho $idade anos"

        btnEnviar.setOnClickListener {

            // verificar se os campos foram preenchidos
            if (!edtNome.text.isEmpty() && !edtIdade.text.isEmpty())
            {
                var nome = edtNome.text.toString()
                // neste exemplo, converter a idade para Int é opcional, tendo em vista
                // que a única coisa que faremos com a idade é interpolar seu valor
                // numa string
                var idade = Integer.parseInt(edtIdade.text.toString())

                var mensagem = "Meu nome é $nome, e tenho $idade anos"

                txtMensagem.text = mensagem

                // limpar os campos de texto
                edtNome.text.clear()
                edtIdade.text.clear()

            }
            else
            {
                // se algum campo estiver vazio, mostramos um Toast
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            }



        }

    }
}