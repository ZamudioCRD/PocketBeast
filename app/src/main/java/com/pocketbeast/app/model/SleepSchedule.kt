package com.pocketbeast.app.model

class SleepSchedule(
    val sleepHour: Int = 24,
    val wakeHour: Int = 8
) {
    fun isSleeping(currentHour: Int): Boolean {
        return currentHour >= sleepHour || currentHour < wakeHour
    }
}