package com.example.aula4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    // declaração global dos atributos (componentes) de interface (views)
    private lateinit var edtNome : EditText
    private lateinit var edtIdade : EditText
    private lateinit var btnCadastrar : Button
    private lateinit var txtCadastro : TextView
    private lateinit var btnAbrir : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // estabelecendo a relação entre os abributos da classe e os
        // componentes da view
        edtNome = findViewById(R.id.edtNome)
        edtIdade = findViewById(R.id.edtIdade)
        btnCadastrar = findViewById(R.id.btnCadastrar)
        txtCadastro = findViewById(R.id.txtCadastro)
        btnAbrir = findViewById(R.id.btnAbrir)

        // ação de clique de botão btnCadastrar
        btnCadastrar.setOnClickListener {

            var mensagem = ""

            if (verificarCampoVazio()){
                mensagem = "Preencha todos os campos!"

            } else if (!validarIdade()) {
                mensagem = "Idade precisa estar entre 1 e 130"
            } else {

                var nome = edtNome.text.toString()
                var idade = edtIdade.text.toString()

                // mostrar dados informados dentro da text view
                txtCadastro.text = "Dados cadastrados\n" +
                        "Nome : $nome\n" +
                        "Idade : $idade"
                // limpar os campos edt
                edtNome.text.clear()
                edtIdade.text.clear()

                mensagem = "Dados cadastrados!"
            }

                // toast com mensagem customizada
                Toast.makeText(this,
                    mensagem,
                    Toast.LENGTH_SHORT).show()
        }

        // ação de clique do botão btnAbrir
        btnAbrir.setOnClickListener {
            // criar intent para acessar outra activity
            var intent = Intent(this, NewActivity::class.java)
            // iniciar activity de acordo com dados da intent
            startActivity(intent)
        }



    }

    private fun verificarCampoVazio() : Boolean {

        return edtNome.text.isEmpty() || edtIdade.text.isEmpty()
    }

    private fun validarIdade() : Boolean {
        var idade = edtIdade.text.toString().toInt()
        return idade in 1..130 // range check
    }
}