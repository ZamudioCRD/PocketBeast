package com.pocketbeast.app.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pocketbeast.app.R
import com.pocketbeast.app.model.CompanionState
import kotlinx.coroutines.delay
import androidx.compose.ui.graphics.graphicsLayer
import com.pocketbeast.app.game.Direction

@Composable
fun WolfAnimation(
    state: CompanionState,
    direction: Direction,
    modifier: Modifier = Modifier
) {
    var currentFrame by remember {
        mutableIntStateOf(0)
    }

    val frames = when (state) {
        CompanionState.Idle -> listOf(
            R.drawable.wolf_idle_000,
            R.drawable.wolf_idle_001
        )

        CompanionState.Sleeping -> listOf(
            R.drawable.wolf_sleep_00,
            R.drawable.wolf_sleep_01
        )

        CompanionState.Hungry -> listOf(
            R.drawable.wolf_hungry_000,
            R.drawable.wolf_hungry_001
        )

        CompanionState.Walking -> listOf(
            R.drawable.wolf_walk_000,
            R.drawable.wolf_walk_001,
            R.drawable.wolf_walk_002,
            R.drawable.wolf_walk_003
        )

        CompanionState.Dirty,
        CompanionState.Sick -> listOf(
            R.drawable.wolf_idle_00,
            R.drawable.wolf_idle_01
        )
    }

    LaunchedEffect(state) {
        currentFrame = 0

        while (true) {
            delay(
                if (state == CompanionState.Walking) 300 else 500
            )

            currentFrame = (currentFrame + 1) % frames.size
        }
    }

    val safeFrame = currentFrame.coerceIn(0, frames.lastIndex)

    Image(
        painter = painterResource(frames[safeFrame]),
        contentDescription = "Fenrir",
        modifier = modifier.graphicsLayer {
            scaleX = if (direction == Direction.Left) {
                1f
            } else {
                -1f
            }
        }
    )
}