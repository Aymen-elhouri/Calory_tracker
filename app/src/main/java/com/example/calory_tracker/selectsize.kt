package com.example.calory_tracker

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class selectsize : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sizing)


        val foodName = intent.getStringExtra("foodName")
        val issolid = intent.getBooleanExtra("issolid",false)
        val protein = intent.getIntExtra("protein",0)
        val carbs = intent.getIntExtra("carbs",0)
        val fats = intent.getIntExtra("fats",0)
        val calories = intent.getIntExtra("calories",0)
        var sizing = ""
        if(issolid==true){
            sizing="Grams"
        }else{sizing="Milliliters"}


        val foodNameTextView = findViewById<TextView>(R.id.textView7)
        foodNameTextView.text = foodName
        val foodsizing = findViewById<TextView>(R.id.textView30)
        foodsizing.text = sizing


        val seekbar = findViewById<SeekBar>(R.id.seekBar)
        val next = findViewById<Button>(R.id.button6)
        val valu = seekbar.progress *10

        val selected  = findViewById<TextView>(R.id.textView11)
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                var value = seekbar.progress *10
                selected.text = value.toString()

            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // This method will be called when the user starts interacting with the SeekBar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // This method will be called when the user stops interacting with the SeekBar
                val progress = seekBar.progress
                // Use the 'progress' variable to get the current value of the SeekBar
            }
        })

        next.setOnClickListener{
            val intent = Intent(this, mainpage::class.java)
            intent.putExtra("foodName", foodName)
            intent.putExtra("size", seekbar.progress)
            intent.putExtra("issolid", issolid)
            intent.putExtra("protein", protein)
            intent.putExtra("carbs", carbs)
            intent.putExtra("fats", fats)
            intent.putExtra("calories", calories)
            startActivity(intent)
        }



    }
}




