package com.example.recipebook

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recipebook.Utils.Companion.CHAVE_SHARED_PREFERENCES
import com.example.recipebook.Utils.Companion.MODE
import com.example.recipebook.Utils.Companion.criarToast
import com.example.recipebook.databinding.ActivityAdicionarReceitaBinding

class AdicionarReceitaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdicionarReceitaBinding

    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var nomeReceita: String
    private lateinit var ingredientesReceita: String
    private lateinit var instrucoesReceita: String

    private val timestamp = System.currentTimeMillis().toString()
    private val chaveReceita = "receita_$timestamp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdicionarReceitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(CHAVE_SHARED_PREFERENCES, MODE)

        binding.btnSalvar.setOnClickListener {
            preencherCampos()

            if (verificarCamposPreenchidos()) {
                val editor = sharedPreferences.edit()

                editor.putString("${chaveReceita}_nome", nomeReceita)
                editor.putString("${chaveReceita}_ingredientes", ingredientesReceita)
                editor.putString("${chaveReceita}_instrucoes", instrucoesReceita)

                editor.apply()
                limparCampos()

                criarToast(this, "Receita salva com sucesso!")
                terminarActivity()
            } else {
                limparCampos()
                criarToast(this, "Todos os campos devem ser preenchidos!")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        limparCampos()
    }

    private fun preencherCampos() {
        nomeReceita = binding.edtNome.text.toString()
        ingredientesReceita = binding.edtIngredientes.text.toString()
        instrucoesReceita = binding.edtInstrucoes.text.toString()
    }

    private fun verificarCamposPreenchidos(): Boolean {
        return nomeReceita.isNotEmpty()
                && ingredientesReceita.isNotEmpty()
                && instrucoesReceita.isNotEmpty()
    }

    private fun limparCampos() {
        binding.edtNome.text.clear()
        binding.edtIngredientes.text.clear()
        binding.edtInstrucoes.text.clear()
    }

    private fun terminarActivity() {
        val resultIntent = Intent()
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

}
