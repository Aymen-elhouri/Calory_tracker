package com.example.calory_tracker

import NutritionDatabase
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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

        lateinit var tv1: ConstraintLayout
        tv1 = findViewById(R.id.breakfastfood)
        lateinit var tv2: ConstraintLayout
        tv2 = findViewById(R.id.lunchfood)
        lateinit var tv3: ConstraintLayout
        tv3 = findViewById(R.id.dinnerfood)

        var deletebreakfast = findViewById<Button>(R.id.deletebreakfast)
        var deletelunch = findViewById<Button>(R.id.deletelunch)
        var deletedinner = findViewById<Button>(R.id.deletedinner)




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

        val sharedPreferences1 = getSharedPreferences("sharedPrefs1", Context.MODE_PRIVATE)
        val editor1 = sharedPreferences1.edit()
        val sharedPreferences2 = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
        val editor2 = sharedPreferences2.edit()
        val sharedPreferences3 = getSharedPreferences("sharedPrefs3", Context.MODE_PRIVATE)
        val editor3 = sharedPreferences3.edit()

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
            if (tv1.visibility == View.VISIBLE) {
                tv1.visibility = View.GONE
            } else {
                tv1.visibility = View.VISIBLE
            }
        }

        constraintLayout1.setOnClickListener {
            if (myView1.visibility == View.VISIBLE) {
                myView1.visibility = View.GONE
            } else {
                myView1.visibility = View.VISIBLE
            }

            if (tv2.visibility == View.VISIBLE) {
                tv2.visibility = View.GONE
            } else {
                tv2.visibility = View.VISIBLE
            }
        }

        constraintLayout2.setOnClickListener {
            if (myView2.visibility == View.VISIBLE) {
                myView2.visibility = View.GONE
            } else {
                myView2.visibility = View.VISIBLE
            }

            if (tv3.visibility == View.VISIBLE) {
                tv3.visibility = View.GONE
            } else {
                tv3.visibility = View.VISIBLE
            }
        }

        myView.setOnClickListener{
            editor.putString("controller","breakfast")
            editor.apply()
            startActivity(Intent(this,search1::class.java))
        }
        myView1.setOnClickListener{
            editor.putString("controller","lunch")
            editor.apply()
            startActivity(Intent(this,search1::class.java))
        }
        myView2.setOnClickListener{
            editor.putString("controller","dinner")
            editor.apply()
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

        val foodItemName = foodName
        val foundFoodItem = NutritionDatabase.searchFoodItemByName(foodItemName.toString())

        fun calcul(foodeditor: SharedPreferences.Editor){
            if (foundFoodItem != null) {
                var sizingunit = ""
                foodeditor.putString("name",foundFoodItem.name)
                foodeditor.putString("foodsizing",foodsize.toString())
                sizingunit = if (foundFoodItem.isSolid){
                    "grams"
                } else{
                    "Milliliters"
                }
                foodeditor.putString("foodunit",sizingunit)
                foodeditor.putInt("calories",((foundFoodItem.calories*(foodsize/100)).toInt()))
                foodeditor.putInt("carbs",(foundFoodItem.carbohydrates*(foodsize/100)).toInt())
                foodeditor.putInt("protein",(foundFoodItem.protein*(foodsize/100)).toInt())
                foodeditor.putInt("fat",(foundFoodItem.fat*(foodsize/100)).toInt())
                foodeditor.apply()
            }
        }

        var result = sharedPreferences.getString("controller","").toString()
        if (result == "breakfast") {
            calcul(editor1)
        }
        if (result == "lunch") {
            calcul(editor2)
        }
        if (result == "dinner") {
            calcul(editor3)
        }

        bname.text= sharedPreferences1.getString("name","")
        sizing.text = sharedPreferences1.getString("foodsizing","")
        unit.text = sharedPreferences1.getString("foodunit","")
        breakfastcaloriestv.text= sharedPreferences1.getInt("calories",0).toString()
        breakfastcarbs.text=  sharedPreferences1.getInt("carbs",0).toString()
        breakfastprotein.text= sharedPreferences1.getInt("protein",0).toString()
        breakfastfat.text=  sharedPreferences1.getInt("fat",0).toString()
        if(bname.text==""){bname.text="Empty"
        deletebreakfast.visibility = View.GONE}


        bname1.text= sharedPreferences2.getString("name","")
        sizing1.text = sharedPreferences2.getString("foodsizing","")
        unit1.text = sharedPreferences2.getString("foodunit","")
        lunchcaloriestv.text= sharedPreferences2.getInt("calories",0).toString()
        lunchcarbs.text=  sharedPreferences2.getInt("carbs",0).toString()
        lunchprotein.text= sharedPreferences2.getInt("protein",0).toString()
        lunchfat.text=  sharedPreferences2.getInt("fat",0).toString()
        if(bname1.text==""){bname1.text="Empty"
            deletelunch.visibility = View.GONE}


        bname2.text= sharedPreferences3.getString("name","")
        sizing2.text = sharedPreferences3.getString("foodsizing","")
        unit2.text = sharedPreferences3.getString("foodunit","")
        dinnercaloriestv.text= sharedPreferences3.getInt("calories",0).toString()
        dinnercarbs.text=  sharedPreferences3.getInt("carbs",0).toString()
        dinnerprotein.text= sharedPreferences3.getInt("protein",0).toString()
        dinnerfat.text=  sharedPreferences3.getInt("fat",0).toString()
        if(bname2.text==""){bname2.text="Empty"
            deletedinner.visibility = View.GONE}



        var totalcalories = (breakfastcaloriestv.text.toString().toInt())+(lunchcaloriestv.text.toString().toInt())+(dinnercaloriestv.text.toString().toInt())
        var totalprotein = (breakfastprotein.text.toString().toDouble())+(lunchprotein.text.toString().toDouble())+(dinnerprotein.text.toString().toDouble())
        var totalcarbs = (breakfastcarbs.text.toString().toDouble()+(lunchcarbs.text.toString().toDouble())+(dinnercarbs.text.toString().toDouble()))
        var totalfat = (breakfastfat.text.toString().toDouble())+(lunchfat.text.toString().toDouble())+(dinnerfat.text.toString().toDouble())

        caloriesprogress.progress = totalcalories
        caloriesate.text = totalcalories.toString()

        carbsprogress.progress = totalcarbs.toInt()
        proteinprogress.progress = totalprotein.toInt()
        fatprogress.progress = totalfat.toInt()

        deletebreakfast.setOnClickListener{
            editor1.putString("name","")
            editor1.putString("foodsizing","")
            editor1.putString("foodunit","")
            editor1.putInt("calories",0)
            editor1.putInt("carbs",0)
            editor1.putInt("protein",0)
            editor1.putInt("fat",0)
            editor1.apply()
            startActivity(Intent(this,mainpage::class.java))
        }
        deletelunch.setOnClickListener{
            editor2.putString("name","")
            editor2.putString("foodsizing","")
            editor2.putString("foodunit","")
            editor2.putInt("calories",0)
            editor2.putInt("carbs",0)
            editor2.putInt("protein",0)
            editor2.putInt("fat",0)
            editor2.apply()
            startActivity(Intent(this,mainpage::class.java))
        }
        deletedinner.setOnClickListener{
            editor3.putString("name","")
            editor3.putString("foodsizing","")
            editor3.putString("foodunit","")
            editor3.putInt("calories",0)
            editor3.putInt("carbs",0)
            editor3.putInt("protein",0)
            editor3.putInt("fat",0)
            editor3.apply()
            startActivity(Intent(this,mainpage::class.java))
        }

























    }}












