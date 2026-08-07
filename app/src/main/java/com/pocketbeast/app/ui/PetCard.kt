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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.offset
import com.pocketbeast.app.game.CompanionMovement
import com.pocketbeast.app.game.Direction

@Composable
fun PetCard(
    companion: Companion,
    modifier: Modifier = Modifier
) {

    val currentHour = Calendar
        .getInstance()
        .get(Calendar.HOUR_OF_DAY)

    val currentState = companion.getState(currentHour)

    var positionX by remember {
        mutableFloatStateOf(0f)
    }

    var direction by remember {
        mutableStateOf(Direction.Right)
    }

    CompanionMovement(
        companion = companion,
        //positionX = positionX,
        //direction = direction,
        onPositionChanged = {
            positionX = it
        },
        onDirectionChanged = {
            direction = it
        }
    )


    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("X: $positionX")

        WolfAnimation(
            state = currentState,
            direction = direction,
            modifier = Modifier
                .offset(x = positionX.dp)
                .size(224.dp)
        )

        CompanionStatBars(
            companion = companion,
            modifier = modifier.fillMaxWidth(0.75f)
        )
        val estado = if (companion.isSleeping(currentHour)) {
            "😴 Dormido"
        } else {
            "😊 Despierto"
        }

        Text("X: $positionX")
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