package com.pocketbeast.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pocketbeast.app.model.Companion
import java.util.Calendar

@Composable
fun PetCard(
    companion: Companion,
    modifier: Modifier = Modifier
) {

    val currentHour = Calendar
        .getInstance()
        .get(Calendar.HOUR_OF_DAY)

    val currentState = companion.getState(currentHour)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        WolfAnimation(
            state = currentState,
            modifier = Modifier.size(224.dp)
        )

        val currentHour = Calendar
            .getInstance()
            .get(Calendar.HOUR_OF_DAY)

        val currentState = companion.getState(currentHour)

        CompanionStatBars(
            companion = companion,
            modifier = Modifier.fillMaxWidth(0.75f)
        )
        val estado = if (companion.isSleeping(currentHour)) {
            "😴 Dormido"
        } else {
            "😊 Despierto"
        }

        Text(estado)
        Text("Estado: ${currentState.name}")

        Button(
            enabled = !companion.isSleeping(currentHour),
            onClick = {
                companion.feed(currentHour)
            }
        ) {
            Text("Alimentar")
        }
    }
}