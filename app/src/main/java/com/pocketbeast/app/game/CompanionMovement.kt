package com.pocketbeast.app.game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.pocketbeast.app.model.Companion
import com.pocketbeast.app.model.CompanionState
import kotlinx.coroutines.delay
import java.util.Calendar

enum class Direction {
    Left,
    Right
}

@Composable
fun CompanionMovement(
    companion: Companion,
    onPositionChanged: (Float) -> Unit,
    onDirectionChanged: (Direction) -> Unit
) {
    LaunchedEffect(companion.id) {

        var positionX = 0f
        var direction = Direction.Right

        while (true) {
            delay(50)

            val currentHour = Calendar
                .getInstance()
                .get(Calendar.HOUR_OF_DAY)

            val state = companion.getState(currentHour)

            if (state == CompanionState.Walking) {

                positionX += if (direction == Direction.Right) {
                    2f
                } else {
                    -2f
                }

                if (positionX >= 150f) {
                    positionX = 150f
                    direction = Direction.Left
                }

                if (positionX <= -150f) {
                    positionX = -150f
                    direction = Direction.Right
                }

                onPositionChanged(positionX)
                onDirectionChanged(direction)
            }
        }
    }
}