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

@Composable
fun WolfAnimation(
    state: CompanionState,
    modifier: Modifier = Modifier
) {
    var currentFrame by remember {
        mutableIntStateOf(0)
    }

    val frames = when (state) {
        CompanionState.Idle -> listOf(
            R.drawable.wolf_idle_00,
            R.drawable.wolf_idle_01
        )

        CompanionState.Sleeping -> listOf(
            R.drawable.wolf_sleep_00,
            R.drawable.wolf_sleep_01
        )

        CompanionState.Hungry -> listOf(
            R.drawable.wolf_hungry_00,
            R.drawable.wolf_hungry_01
        )

        CompanionState.Walking -> listOf(
            R.drawable.wolf_walk_00,
            R.drawable.wolf_walk_01,
            R.drawable.wolf_walk_02,
            R.drawable.wolf_walk_03,
            R.drawable.wolf_walk_04,
            R.drawable.wolf_walk_05,
            R.drawable.wolf_walk_06
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

    Image(
        painter = painterResource(frames[currentFrame]),
        contentDescription = "Fenrir: ${state.name}",
        modifier = modifier
    )
}