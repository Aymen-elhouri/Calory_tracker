package com.example.calory_tracker


import FoodItemAdapter
import NutritionDatabase.Companion.foodItems
import android.os.Bundle
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class search1 : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var foodListView: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search1)

        searchEditText = findViewById(R.id.searchEditText)
        foodListView = findViewById(R.id.foodListView)

        val adapter = FoodItemAdapter(this, R.layout.list_item_food, foodItems)
        foodListView.adapter = adapter

    }
}