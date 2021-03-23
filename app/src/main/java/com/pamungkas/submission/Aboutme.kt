package com.pamungkas.submission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Aboutme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutme)

        val btnBack = findViewById<ImageView>(R.id.btn_back_aboutme)
        btnBack.setOnClickListener {
            finish()
        }
    }
}