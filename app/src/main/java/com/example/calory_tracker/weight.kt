package com.example.calory_tracker

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class weight : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        var next = findViewById<Button>(R.id.button2)
        var weight = findViewById<EditText>(R.id.edittext)


        next.setOnClickListener(){
            val userInput = weight.text.toString()
            val userNumber = userInput.toIntOrNull()
            if(userNumber!=null){
                if(userNumber<10 || userNumber>500){
                    Toast.makeText(this, "enter a valid age!", Toast.LENGTH_SHORT).show()
                }
                else{
                    editor.putInt("weight",userNumber)
                    editor.apply()
                    startActivity(Intent(this,height::class.java))

                }
        }
    }}}
