package com.pocketbeast.app.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pocketbeast.app.model.Companion

@Composable
fun StatBar(
    label: String,
    value: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text("$label: $value")

        LinearProgressIndicator(
            progress = { value / 100f },
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
        )
    }
}

@Composable
fun CompanionStatBars(
    companion: Companion,
    modifier: Modifier = Modifier
) {
    val stats = listOf(
        "Hambre" to companion.stats.hunger,
        "Energía" to companion.stats.energy,
        "Limpieza" to companion.stats.cleanliness,
        "Salud" to companion.stats.health
    )

    Column(modifier = modifier) {
        stats.forEach { (label, value) ->
            StatBar(
                label = label,
                value = value
            )
        }
    }
}