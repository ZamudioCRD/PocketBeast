package com.pocketbeast.app.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

class Stats(
    hunger: Int,
    energy: Int,
    cleanliness: Int,
    health: Int
) {
    var hunger by mutableIntStateOf(hunger)
        private set

    var energy by mutableIntStateOf(energy)
        private set

    var cleanliness by mutableIntStateOf(cleanliness)
        private set

    var health by mutableIntStateOf(health)
        private set

    fun feed(amount: Int = 10) {
        hunger = (hunger - amount).coerceAtLeast(0)
    }

    fun shower(amount: Int = 10) {
        cleanliness = (cleanliness + amount).coerceAtLeast(MAX_CLEANLINESS)
    }

    fun heal(amount: Int = 10) {
        health = (health + amount).coerceAtLeast(MAX_HEALTH)
    }

    fun passTime(isSleeping: Boolean) {
        hunger = (hunger + 1).coerceAtMost(MAX_HUNGER)

        cleanliness = (cleanliness - 1)
            .coerceAtLeast(0)

        energy = if (isSleeping) {
            (energy + 2).coerceAtMost(MAX_ENERGY)
        } else {
            (energy - 1).coerceAtLeast(0)
        }
    }

    companion object {

        const val MAX_HUNGER = 100

        const val MAX_ENERGY = 100

        const val MAX_HEALTH = 100

        const val MAX_CLEANLINESS = 100

    }
}

