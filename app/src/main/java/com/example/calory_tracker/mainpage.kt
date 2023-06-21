package com.example.calory_tracker

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class mainpage : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainpage)
        lateinit var toggleButton: Button
        lateinit var myView: View
        lateinit var constraintLayout: ConstraintLayout
        lateinit var myView1: View
        lateinit var constraintLayout1: ConstraintLayout
        lateinit var myView2: View
        lateinit var constraintLayout2: ConstraintLayout

        val caloriestv = findViewById<TextView>(R.id.textView15)
        val carbs = findViewById<TextView>(R.id.textView18)
        val protein = findViewById<TextView>(R.id.textView22)
        val fat = findViewById<TextView>(R.id.textView23)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        var calories = sharedPreferences.getInt("calories",0)

        var carbsval = sharedPreferences.getInt("finalcarbsgoal",0)
        var proteinval = sharedPreferences.getInt("finalproteingoal",0)
        var fatval = sharedPreferences.getInt("finalfatgoal",0)


        caloriestv.text = calories.toString()
        carbs.text = carbsval.toString()
        protein.text = proteinval.toString()
        fat.text = fatval.toString()

        constraintLayout = findViewById(R.id.dropping1)
        myView = findViewById(R.id.button3)

        constraintLayout1 = findViewById(R.id.dropping2)
        myView1 = findViewById(R.id.button4)

        constraintLayout2 = findViewById(R.id.dropping3)
        myView2 = findViewById(R.id.button5)


        constraintLayout.setOnClickListener {
            if (myView.visibility == View.VISIBLE) {
                myView.visibility = View.GONE
            } else {
                myView.visibility = View.VISIBLE
            }
        }

        constraintLayout1.setOnClickListener {
            if (myView1.visibility == View.VISIBLE) {
                myView1.visibility = View.GONE
            } else {
                myView1.visibility = View.VISIBLE
            }
        }

        constraintLayout2.setOnClickListener {
            if (myView2.visibility == View.VISIBLE) {
                myView2.visibility = View.GONE
            } else {
                myView2.visibility = View.VISIBLE
            }
        }

        myView.setOnClickListener{
            startActivity(Intent(this,search1::class.java))
        }







    }}












