package com.example.recipebook

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.recipebook.Utils.Companion.CHAVE_SHARED_PREFERENCES
import com.example.recipebook.Utils.Companion.MODE
import com.example.recipebook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val listaReceitas = mutableListOf<String>()

    private lateinit var btnAdicionar: Button
    private lateinit var listView: ListView

    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var keys: MutableSet<String>

    private val ChaveNomeMap = mutableMapOf<String, String>()

    private val startAddRecipeActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                recreate()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(CHAVE_SHARED_PREFERENCES, MODE)

        listView = binding.listaReceitasView
        btnAdicionar = binding.btnAdicionar

        criarAdapter()
        popularListaReceitas()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val nomeReceitaSelecionada = listaReceitas[position]
            val chaveReceitaSelecionada = ChaveNomeMap[nomeReceitaSelecionada]

            if (chaveReceitaSelecionada != null) {
                criarNovaActivity(chaveReceitaSelecionada)
            } else {
                println("\"Erro ao recuperar ao valor da receita: $nomeReceitaSelecionada")
            }
        }

        btnAdicionar.setOnClickListener {
            val intent = Intent(this, AdicionarReceitaActivity::class.java)
            startAddRecipeActivity.launch(intent)
        }
    }

    private fun popularListaReceitas() {
        keys = sharedPreferences.all.keys

        for (chave in keys) {
            println(chave)
            if (chave.endsWith("_nome")) {
                val receita = sharedPreferences.getString(chave, "")
                if (receita?.isNotEmpty() == true) {
                    listaReceitas.add(receita)
                    val chaveUnica = chave.removeSuffix("_nome")
                    ChaveNomeMap[receita] = chaveUnica
                } else {
                    println("Erro ao recuperar ao valor da chave: $chave")
                }
            }
        }

    }

    private fun criarAdapter() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaReceitas)
        listView.adapter = adapter
    }

    private fun criarNovaActivity(chaveReceitaSelecionada: String) {
        val intent = Intent(this, DetalhesReceitaActivity::class.java)
        intent.putExtra("chave_receita", chaveReceitaSelecionada)
        startActivity(intent)
    }
}



