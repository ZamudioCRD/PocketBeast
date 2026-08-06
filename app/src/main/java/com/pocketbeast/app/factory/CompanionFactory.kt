package com.pocketbeast.app.factory

import com.pocketbeast.app.model.*
import java.util.UUID

object CompanionFactory {

    private fun createDefaultStats() = Stats(
        hunger = 50,
        energy = 50,
        cleanliness = Stats.MAX_CLEANLINESS,
        health = Stats.MAX_HEALTH
    )

    private fun createDefaultSleepSchedule() = SleepSchedule()

    fun createWolf(name: String): Companion {

        return Companion(
            id = UUID.randomUUID().toString(),
            name = name,
            species = Species(
                id = "wolf",
                name = "Lobo"
            ),
            stats = createDefaultStats(),
            sleepSchedule = createDefaultSleepSchedule()
        )
    }

    fun createCrow(name: String): Companion {

        return Companion(
            id = UUID.randomUUID().toString(),
            name = name,
            species = Species(
                id = "crow",
                name = "Cuervo"
            ),
            stats = createDefaultStats(),
            sleepSchedule = createDefaultSleepSchedule()
        )
    }

    fun createCat(name: String): Companion {

        return Companion(
            id = UUID.randomUUID().toString(),
            name = name,
            species = Species(
                id = "cat",
                name = "Gato"
            ),
            stats = createDefaultStats(),
            sleepSchedule = createDefaultSleepSchedule()
        )
    }
}