package com.example.recipebook

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.recipebook.Utils.Companion.CHAVE_SHARED_PREFERENCES
import com.example.recipebook.Utils.Companion.MODE
import com.example.recipebook.Utils.Companion.criarToast
import com.example.recipebook.databinding.ActivityDetalhesReceitaBinding
import java.util.Objects.nonNull

class DetalhesReceitaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesReceitaBinding


    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var nomeReceita: TextView
    private lateinit var ingredientesReceita: TextView
    private lateinit var instrucoesReceita: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalhesReceitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chaveReceita = intent.getStringExtra("chave_receita")

        sharedPreferences = getSharedPreferences(CHAVE_SHARED_PREFERENCES, MODE)

        preencherCampos()

        if (nonNull(chaveReceita)) {
            nomeReceita.text = sharedPreferences.getString("${chaveReceita}_nome", "")
            ingredientesReceita.text =
                sharedPreferences.getString("${chaveReceita}_ingredientes", "")
            instrucoesReceita.text = sharedPreferences.getString("${chaveReceita}_instrucoes", "")
        } else {
            criarToast(this, "Erro ao carregar receita!")
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        nomeReceita.clearComposingText()
        ingredientesReceita.clearComposingText()
        instrucoesReceita.clearComposingText()
    }

    private fun preencherCampos() {
        nomeReceita = binding.edtNomeTextView
        ingredientesReceita = binding.edtIngredientesTextView
        instrucoesReceita = binding.edtInstrucoesTextView
    }
}