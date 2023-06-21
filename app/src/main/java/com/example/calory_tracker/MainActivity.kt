package com.example.calory_tracker

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val isFirstUse = sharedPreferences.getBoolean("isFirstUse", true)


        if (isFirstUse) {
            // Prompt the user to enter their information
            // ...
            // After the user enters the information, store it in shared preferences
            GlobalScope.launch {
                delay(5000) // Pause the execution for 5 seconds

                // Code after the delay
            }

            startActivity(Intent(this, greet::class.java))

        } else {
            GlobalScope.launch {
                delay(5000) // Pause the execution for 5 seconds

                // Code after the delay
            }

            startActivity(Intent(this, mainpage::class.java))

        }


    }
}