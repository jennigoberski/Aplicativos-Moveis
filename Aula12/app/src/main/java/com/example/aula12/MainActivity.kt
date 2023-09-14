package com.example.aula12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aula12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tarefaAdapter: TarefaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tarefaAdapter = TarefaAdapter()
        binding.rcvTarefas.layoutManager = LinearLayoutManager(this)
        binding.rcvTarefas.adapter = tarefaAdapter

        binding.btnAdd.setOnClickListener {

            if (binding.edtTarefa.text.isNotEmpty()){
                ListaTarefas.addTarefa(Tarefa(binding.edtTarefa.text.toString()))
                tarefaAdapter.notifyItemInserted(ListaTarefas.getListSize() - 1)
                binding.edtTarefa.text.clear()
            }

        }

    }
}