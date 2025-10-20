package com.example.s8153655_assignment2.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.s8153655_assignment2.data.model.Entity

@Composable
fun DashboardScreen(
    entities: List<Entity>,
    onEntityClick: (Entity) -> Unit
) {
    Text(
        text = "Dashboard",
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier.padding(bottom = 16.dp)
    )

    Text(
        text = "Total Entities: ${entities.size}",
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(bottom = 16.dp)
    )

    if (entities.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            Text("No entities found")
        }

    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

        }
}