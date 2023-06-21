package com.example.calory_tracker

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class height : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_height)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        var next = findViewById<Button>(R.id.button2)
        var height = findViewById<EditText>(R.id.edittext)


        next.setOnClickListener(){
            val userInput = height.text.toString()
            val userNumber = userInput.toIntOrNull()
            if(userNumber!=null){
                if(userNumber<50 || userNumber>300){
                    Toast.makeText(this, "enter a valid height!", Toast.LENGTH_SHORT).show()
                }
                else{
                    editor.putInt("height",userNumber)
                    editor.apply()
                    startActivity(Intent(this,activitylevel::class.java))

                }

            }
    }
}}