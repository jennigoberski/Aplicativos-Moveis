package com.example.gerenciadorcompromissos.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gerenciadorcompromissos.CompromissoAdapter
import com.example.gerenciadorcompromissos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CompromissoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CompromissoAdapter(this)

        binding.rcvCompromissos.layoutManager = LinearLayoutManager(this)
        binding.rcvCompromissos.adapter = adapter

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AdicionarCompromissoActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        adapter.notifyDataSetChanged()
    }

}