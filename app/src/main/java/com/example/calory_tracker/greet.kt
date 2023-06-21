package com.example.calory_tracker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class greet : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greet)

        var next = findViewById<Button>(R.id.button)
        next.setOnClickListener() {
            startActivity(Intent(this, gender::class.java))
        }
    }}