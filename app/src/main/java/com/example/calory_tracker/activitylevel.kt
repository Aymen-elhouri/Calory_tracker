package com.example.calory_tracker

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

class activitylevel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activitylevel)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        var low = findViewById<Button>(R.id.low)
        var med = findViewById<Button>(R.id.med)
        var high = findViewById<Button>(R.id.high)
        var checker = ""
        fun colorit(){
            if (checker=="low"){
                low.setBackgroundColor(Color.parseColor("#669900"))
                med.setBackgroundColor(Color.WHITE)
                high.setBackgroundColor(Color.WHITE)
            }
            if (checker=="med"){
                med.setBackgroundColor(Color.parseColor("#669900"))
                low.setBackgroundColor(Color.WHITE)
                high.setBackgroundColor(Color.WHITE)
            }
            if (checker=="high"){
                high.setBackgroundColor(Color.parseColor("#669900"))
                med.setBackgroundColor(Color.WHITE)
                low.setBackgroundColor(Color.WHITE)
            }
        }

        low.setOnClickListener(){
            checker = "low"
            colorit()
        }
        med.setOnClickListener(){
            checker = "med"
            colorit()
        }
        high.setOnClickListener(){
            checker = "high"
            colorit()
        }


        var next = findViewById<Button>(R.id.button4)

        next.setOnClickListener(){
            if(checker==""){
                Toast.makeText(this, "chose your activity level!", Toast.LENGTH_SHORT).show()
            }else{
                editor.putString("activitylevel",checker)
                editor.apply()

                startActivity(Intent(this,goal::class.java))
            }

        }
    }
}