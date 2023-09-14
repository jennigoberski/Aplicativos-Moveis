package com.example.aula12b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aula12b.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var carroAdapter: CarroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carroAdapter = CarroAdapter(this)
        binding.rcvCarros.layoutManager = LinearLayoutManager(this)
        binding.rcvCarros.adapter = carroAdapter

    }

    override fun onStart() {
        super.onStart()
        carroAdapter.notifyDataSetChanged()
    }
}