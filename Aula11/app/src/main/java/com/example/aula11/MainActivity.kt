package com.example.aula11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aula11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // inicializar a instancia do itemAdapter
        itemAdapter = ItemAdapter()
        // setar orientação do layout (padrão linear layou verical) e o contexto onde a recycler view existe
        binding.rclItens.layoutManager = LinearLayoutManager(this)
        // setar adapter para a recycler view
        binding.rclItens.adapter = itemAdapter

        // ação de clique do botao
        binding.btnNovoItem.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        // notificar recycler view cada vez que houver alteração nos valores da lista
        // (não importa se esses valores forma adicionados, editados ou removidos)
        itemAdapter.notifyDataSetChanged()
    }
}