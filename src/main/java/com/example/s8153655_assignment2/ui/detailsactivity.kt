package com.example.s8153655assignment2.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.s8153655_assignment2.R

class DetailsActivity : AppCompatActivity(R.layout.activity_details) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<TextView>(R.id.tvProp1).text = intent.getStringExtra("property1")
        findViewById<TextView>(R.id.tvProp2).text = intent.getStringExtra("property2")
        findViewById<TextView>(R.id.tvDesc).text = intent.getStringExtra("description")
    }
}
