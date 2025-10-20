package com.example.s8153655assignment2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.s8153655_assignment2.R
import com.example.s8153655_assignment2.ui.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity(R.layout.activity_dashboard) {
    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = findViewById<ListView>(R.id.listView)
        val keypass = intent.getStringExtra("keypass") ?: ""

        viewModel.entities.observe(this) { list ->
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list.map { it.property1 })
            listView.adapter = adapter

            listView.setOnItemClickListener { _, _, position, _ ->
                val entity = list[position]
                val intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra("property1", entity.property1)
                intent.putExtra("property2", entity.property2)
                intent.putExtra("description", entity.description)
                startActivity(intent)
            }
        }

        viewModel.loadDashboard(keypass)
    }
}
