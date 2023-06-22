package com.example.calory_tracker

import NutritionDatabase
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
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
        lateinit var myView2: Button
        myView2 = findViewById(R.id.button5)
        lateinit var constraintLayout2: ConstraintLayout
        constraintLayout2 = findViewById(R.id.dropping3)

        val caloriestv = findViewById<TextView>(R.id.textView15)
        val carbs = findViewById<TextView>(R.id.textView18)
        val protein = findViewById<TextView>(R.id.textView22)
        val fat = findViewById<TextView>(R.id.textView23)
        val caloriesate = findViewById<TextView>(R.id.textView17)


        val caloriesprogress = findViewById<ProgressBar>(R.id.progressBar)
        val carbsprogress = findViewById<ProgressBar>(R.id.progressBar2)
        val proteinprogress = findViewById<ProgressBar>(R.id.progressBar3)
        val fatprogress = findViewById<ProgressBar>(R.id.progressBar4)


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
        caloriesprogress.max = calories
        carbsprogress.max = carbsval
        proteinprogress.max = proteinval
        fatprogress.max = fatval


            constraintLayout = findViewById(R.id.dropping1)
        myView = findViewById(R.id.button3)

        constraintLayout1 = findViewById(R.id.dropping2)
        myView1 = findViewById(R.id.button4)



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


        val breakfastcaloriestv = findViewById<TextView>(R.id.textView71)
        val breakfastcarbs = findViewById<TextView>(R.id.textView73)
        val breakfastprotein = findViewById<TextView>(R.id.textView35)
        val breakfastfat = findViewById<TextView>(R.id.textView36)

        val lunchcaloriestv = findViewById<TextView>(R.id.textView101)
        val lunchcarbs = findViewById<TextView>(R.id.textView112)
        val lunchprotein = findViewById<TextView>(R.id.textView108)
        val lunchfat = findViewById<TextView>(R.id.textView104)

        val dinnercaloriestv = findViewById<TextView>(R.id.textView201)
        val dinnercarbs = findViewById<TextView>(R.id.textView212)
        val dinnerprotein = findViewById<TextView>(R.id.textView208)
        val dinnerfat = findViewById<TextView>(R.id.textView204)






        val bname = findViewById<TextView>(R.id.foodNameTextView)
        val sizing = findViewById<TextView>(R.id.sizing)
        val unit = findViewById<TextView>(R.id.sizing4)

        val bname1 = findViewById<TextView>(R.id.foodNameTextView1)
        val sizing1 = findViewById<TextView>(R.id.sizing1)
        val unit1 = findViewById<TextView>(R.id.sizing41)

        val bname2 = findViewById<TextView>(R.id.foodNameTextView2)
        val sizing2 = findViewById<TextView>(R.id.sizing2)
        val unit2 = findViewById<TextView>(R.id.sizing42)




        val foodName = intent.getStringExtra("foodName")
        val foodsize = intent.getIntExtra("size",0)*10
        val foodprotein = intent.getIntExtra("protein",0)
        val foodcarbs = intent.getIntExtra("carbs",0)
        val foodcalories = intent.getIntExtra("calories",0)

        val foodItemName = foodName
        val foundFoodItem = NutritionDatabase.searchFoodItemByName(foodItemName.toString())

        if (foundFoodItem != null) {
            bname.text=foundFoodItem.name
            if(foodsize!=0){
                sizing.text = foodsize.toString()}
            if (foundFoodItem.isSolid){
                unit.text = "grams"
            }
            else{unit.text = "Milliliters"}
            breakfastcaloriestv.text=((foundFoodItem.calories*(foodsize/100)).toInt()).toString()
            breakfastcarbs.text= (foundFoodItem.carbohydrates*(foodsize/100)).toString()
            breakfastprotein.text= (foundFoodItem.protein*(foodsize/100)).toString()
            breakfastfat.text= (foundFoodItem.fat*(foodsize/100)).toString()
        }









        var totalcalories = (breakfastcaloriestv.text.toString().toInt())+(lunchcaloriestv.text.toString().toInt())+(dinnercaloriestv.text.toString().toInt())
        var totalprotein = (breakfastprotein.text.toString().toDouble())+(lunchprotein.text.toString().toDouble())+(dinnerprotein.text.toString().toDouble())
        var totalcarbs = (breakfastcarbs.text.toString().toDouble()+(lunchcarbs.text.toString().toDouble())+(dinnercarbs.text.toString().toDouble()))
        var totalfat = (breakfastfat.text.toString().toDouble())+(lunchfat.text.toString().toDouble())+(dinnerfat.text.toString().toDouble())

        caloriesprogress.progress = totalcalories
        caloriesate.text = totalcalories.toString()

        carbsprogress.progress = totalcarbs.toInt()
        proteinprogress.progress = totalprotein.toInt()
        fatprogress.progress = totalfat.toInt()

















    }}












