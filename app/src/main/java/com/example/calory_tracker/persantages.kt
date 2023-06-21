package com.example.calory_tracker

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class persantages : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persantages)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        var next = findViewById<Button>(R.id.button5)
        var per1 = findViewById<EditText>(R.id.per1)
        var per2 = findViewById<EditText>(R.id.per2)
        var per3 = findViewById<EditText>(R.id.per3)

        next.setOnClickListener(){
            val userInput1 = per1.text.toString()
            val userNumber1 = userInput1.toIntOrNull()

            val userInput2 = per2.text.toString()
            val userNumber2 = userInput2.toIntOrNull()

            val userInput3 = per3.text.toString()
            val userNumber3 = userInput3.toIntOrNull()

            if(userNumber1!=null && userNumber2!=null && userNumber3!=null ){
                if(userNumber1+userNumber2+userNumber3==100){

                    editor.putInt("carbsgoal",userNumber1)
                    editor.putInt("proteingoal",userNumber2)
                    editor.putInt("fatgoal",userNumber3)
                    editor.apply()

                    val gender = sharedPreferences.getString("gender","").toString()
                    val age = sharedPreferences.getInt("age",0)
                    val weight = sharedPreferences.getInt("weight",0)
                    val height = sharedPreferences.getInt("height",0)
                    val activitylevel = sharedPreferences.getString("activitylevel","").toString()
                    val goal = sharedPreferences.getString("goal","").toString()
                    val carbsgoal = sharedPreferences.getInt("carbsgoal",0)
                    val proteinsgoal = sharedPreferences.getInt("proteingoal",0)
                    val fatsgoal = sharedPreferences.getInt("fatgoal",0)


                    fun BMR(): Int {
                        var extra =0
                        if(gender=="male"){
                            extra = 5
                        }
                        else{
                            extra= -161

                        }
                        var bmr = ((10*weight)+(6.25*height)-(5*age)+extra)
                        return bmr.toInt()
                    }

                    fun AMR(): Int {
                        var amr = 0
                        if(activitylevel=="low"){
                            amr = (BMR()*1.375).toInt()
                        }
                        if(activitylevel=="med"){
                            amr = (BMR()*1.55).toInt()
                        }
                        if(activitylevel=="high"){
                            amr = (BMR()*1.725).toInt()
                        }
                        return amr
                    }
                    fun calculcalories():Int{
                        var calories = 0
                        if(goal=="lose"){
                            calories = (AMR()-400).toInt()
                        }
                        if(goal=="keep"){
                            calories  = AMR().toInt()
                        }
                        if(goal=="gain"){
                            calories  = (AMR()+400).toInt()
                        }
                        return calories
                    }
                    
                    var carbsamount:Int= ((calculcalories()*(carbsgoal*0.01))*0.25).toInt()
                    var proteinamount:Int=((calculcalories()*(proteinsgoal*0.01))*0.25).toInt()
                    var fatamount:Int=((calculcalories()*(fatsgoal*0.01))*0.111111111111).toInt()

                    editor.putInt("finalcarbsgoal",carbsamount)
                    editor.putInt("finalproteingoal",proteinamount)
                    editor.putInt("finalfatgoal",fatamount)

                    editor.putInt("calories",calculcalories())
                    editor.putBoolean("isFirstUse", false)
                    editor.apply()

                    startActivity(Intent(this,mainpage::class.java))
                }
                else{
                    Toast.makeText(this, "enter valid percentages!", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}