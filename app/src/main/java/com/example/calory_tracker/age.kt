package com.example.calory_tracker

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class age : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        var next = findViewById<Button>(R.id.button2)
        var age = findViewById<EditText>(R.id.editText)


        next.setOnClickListener(){
            val userInput = age.text.toString()
            val userNumber = userInput.toIntOrNull()
            if(userNumber!=null){
                if(userNumber<5 || userNumber>100){
                    Toast.makeText(this, "enter a valid age!", Toast.LENGTH_SHORT).show()

                }
                else{
                    editor.putInt("age",userNumber)
                    editor.apply()

                    startActivity(Intent(this,weight::class.java))
                }
            }

        }
    }
}