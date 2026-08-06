package com.pocketbeast.app.model

import kotlin.compareTo

class Companion(
    val id: String,
    var name: String,
    val species: Species,
    val stats: Stats,
    val sleepSchedule: SleepSchedule
) {
    fun feed(currentHour: Int): Boolean {

        if (isSleeping(currentHour)) {
            return false
        }

        stats.feed()

        return true
    }

    fun isSleeping(currentHour: Int): Boolean {
        return sleepSchedule.isSleeping(currentHour)
    }

    fun passTime(currentHour: Int) {
        val sleeping = isSleeping(currentHour)

        stats.passTime(
            isSleeping = sleeping
        )
    }

    fun getState(currentHour: Int): CompanionState {

        if (isSleeping(currentHour)) {
            return CompanionState.Sleeping
        }

        if (stats.health <= 30) {
            return CompanionState.Sick
        }

        if (stats.cleanliness <= 30) {
            return CompanionState.Dirty
        }

        if (stats.hunger >= 30) {
            return CompanionState.Hungry
        }

        return CompanionState.Walking

        //return CompanionState.Idle
    }
}