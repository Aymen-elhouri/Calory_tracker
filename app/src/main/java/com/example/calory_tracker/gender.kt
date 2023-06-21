package com.example.calory_tracker

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

class gender : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gender)

        val sharedPreferences = getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        var male = findViewById<Button>(R.id.male)
        var female = findViewById<Button>(R.id.female)
        var checker = ""
        fun colorit(){
            if (checker=="female"){
                female.backgroundTintList = getColorStateList(android.R.color.holo_green_dark)
                male.backgroundTintList = getColorStateList(android.R.color.white)
            }
            if (checker=="male"){
                male.backgroundTintList = getColorStateList(android.R.color.holo_green_dark)
                female.backgroundTintList = getColorStateList(android.R.color.white)
            }}

        female.setOnClickListener(){
            checker = "female"
            colorit()
        }
        male.setOnClickListener(){
            checker = "male"
            colorit()
        }


        var next = findViewById<Button>(R.id.button4)

        next.setOnClickListener(){
            if(checker==""){
                Toast.makeText(this, "chose your gender!", Toast.LENGTH_SHORT).show()
            }
            else{
                editor.putString("gender",checker)
                editor.apply()
                startActivity(Intent(this,age::class.java))}
        }
    }
}