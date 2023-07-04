package com.example.calory_tracker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val isFirstUse = sharedPreferences.getBoolean("isFirstUse", true)


        if (isFirstUse) {

            startActivity(Intent(this, greet::class.java))

        } else {

            startActivity(Intent(this, mainpage::class.java))

        }


    }
}