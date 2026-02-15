package com.example.lab3mobile

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3mobile.model.TipRepository

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar)
        toolbar.title = getString(R.string.detail_title)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        val tipId = intent.getIntExtra("TIP_ID", 1)
        val tip = TipRepository.tips.find { it.id == tipId } ?: return

        findViewById<ImageView>(R.id.ivDetailImage).setImageResource(tip.imageRes)
        findViewById<TextView>(R.id.tvDetailTitle).setText(tip.titleRes)
        findViewById<TextView>(R.id.tvDetailFullText).setText(tip.fullDescRes)

    }
}
