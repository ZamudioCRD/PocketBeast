package com.pocketbeast.app.game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.pocketbeast.app.model.Companion
import kotlinx.coroutines.delay
import java.util.Calendar

@Composable
fun CompanionGameLoop(
    companion: Companion
) {
    LaunchedEffect(companion.id) {
        while (true) {
            delay(5_000)

            val currentHour = Calendar
                .getInstance()
                .get(Calendar.HOUR_OF_DAY)

            companion.passTime(
                currentHour = currentHour
            )
        }
    }
}