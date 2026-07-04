@file:Suppress("SpellCheckingInspection")

/**
 *
 *Instructions
 *
 * Implement a clock that handles times without dates.
 *
 * You should be able to add and subtract minutes to it.
 *
 * Two clocks that represent the same time should be equal to each other.
 *
 *
 *
 */

class Clock(val hour: Int, val minute: Int) {


    fun subtract(minutes: Int) {

    }

    fun add(minutes: Int): Clock {
        // aquí puedes usar hour y minute directamente
        val totalMinutes = hour * 60 + minute + minutes
        val newHour = (totalMinutes / 60) % 24
        val newMinute = totalMinutes % 60
        return Clock(newHour, newMinute)
    }
}

fun main(){
    Clock(10, 30)   // 10:30
    Clock(23, 50)   // 23:50
    Clock(0, 0)     // 00:00
    
}