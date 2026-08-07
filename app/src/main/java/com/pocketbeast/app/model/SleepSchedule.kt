package com.pocketbeast.app.model

class SleepSchedule(
    val sleepHour: Int = 21,
    val wakeHour: Int = 9
) {
    fun isSleeping(currentHour: Int): Boolean {
        return currentHour >= sleepHour || currentHour < wakeHour
    }
}