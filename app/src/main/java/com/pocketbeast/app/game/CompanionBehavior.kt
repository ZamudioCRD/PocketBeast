package com.pocketbeast.app.game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.pocketbeast.app.model.Companion
import com.pocketbeast.app.model.CompanionActivity
import kotlinx.coroutines.delay
import java.util.Calendar
import kotlin.random.Random

@Composable
fun CompanionBehavior(
    companion: Companion
) {
    LaunchedEffect(companion.id) {
        while (true) {

            delay(
                Random.nextLong(
                    3_000,
                    7_000
                )
            )

            val currentHour = Calendar
                .getInstance()
                .get(Calendar.HOUR_OF_DAY)

            val cannotWalk =
                companion.isSleeping(currentHour) ||
                        companion.stats.health <= 30 ||
                        companion.stats.cleanliness <= 30 ||
                        companion.stats.hunger >= 70

            if (cannotWalk) {
                companion.stopWalking()
                continue
            }

            when (companion.activity) {
                CompanionActivity.Idle ->
                    companion.startWalking()

                CompanionActivity.Walking ->
                    companion.stopWalking()
            }
        }
    }
}