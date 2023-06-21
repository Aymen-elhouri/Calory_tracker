package com.example.calory_tracker

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class goal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        var low = findViewById<Button>(R.id.low)
        var med = findViewById<Button>(R.id.med)
        var high = findViewById<Button>(R.id.high)
        var checker = ""
        fun colorit(){
            if (checker=="lose"){
                low.setBackgroundColor(Color.parseColor("#669900"))
                med.setBackgroundColor(Color.WHITE)
                high.setBackgroundColor(Color.WHITE)
            }
            if (checker=="keep"){
                med.setBackgroundColor(Color.parseColor("#669900"))
                low.setBackgroundColor(Color.WHITE)
                high.setBackgroundColor(Color.WHITE)
            }
            if (checker=="gain"){
                high.setBackgroundColor(Color.parseColor("#669900"))
                med.setBackgroundColor(Color.WHITE)
                low.setBackgroundColor(Color.WHITE)
            }
        }

        low.setOnClickListener(){
            checker = "lose"
            colorit()
        }
        med.setOnClickListener(){
            checker = "keep"
            colorit()
        }
        high.setOnClickListener(){
            checker = "gain"
            colorit()
        }


        var next = findViewById<Button>(R.id.button4)

        next.setOnClickListener(){
            if(checker==""){
                Toast.makeText(this, "chose your goal!", Toast.LENGTH_SHORT).show()
            }else{
                editor.putString("goal",checker)
                editor.apply()

                startActivity(Intent(this,persantages::class.java))
            }
        }

    }
}