package com.example.lab3mobile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3mobile.adapter.TipsAdapter
import com.example.lab3mobile.model.TipRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = TipsAdapter(TipRepository.tips) { tip ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("TIP_ID", tip.id)
            }
            startActivity(intent)
        }
    }
}