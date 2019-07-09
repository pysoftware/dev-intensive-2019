package com.magere.dev_intensive_2019.extensions

import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern
import kotlin.math.abs

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.DAY -> value * DAY
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
    }

    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {

    var res: String

    var diff = (Date().time - date.time) / 1000

    var min = diff / 60
    var hour = min / 60
    var day = hour / 24

    if (diff < 0) {

        diff--
        min = diff / 60
        hour = min / 60
        day = hour / 24
        min = abs(min)
        hour = abs(hour)
        day = abs(day)
    }

    when (diff) {
        in -1..0 -> res = "через секунду"
        in -45..-1 -> res = "через несколько секунд"
        in -75..-45 -> res = "через минуту"
        in -45 * 60..-75 -> res =
            "через $min ${if ((min % 10 == 0L) or (min % 10 == 5L) or (min % 10 == 6L) or (min % 10 == 7L) or (min % 10 == 8L) or (min % 10 == 9L) or ((min > 10L) and (min < 20L))) "минут" else if ((min % 10 == 2L) or (min % 10 == 3L) or (min % 10 == 4L)) "минуты" else "минуту"}"
        in -75 * 60..-45 * 60 -> res = "через час"
        in -22 * 60 * 60..-75 * 60 -> res =
            "через $hour ${if ((min % 10 == 0L) or (min % 10 == 5L) or (min % 10 == 6L) or (min % 10 == 7L) or (min % 10 == 8L) or (min % 10 == 9L) or ((min > 10L) and (min < 20L))) "часов" else if ((min % 10 == 2L) or (min % 10 == 3L) or (min % 10 == 4L)) "часа" else "час"}"
        in -26 * 60 * 60..-22 * 60 * 60 -> res = "через день"
        in -360 * 24 * 60 * 60..-26 * 60 * 60 -> res =
            "через $day ${if ((min % 10 == 0L) or (min % 10 == 5L) or (min % 10 == 6L) or (min % 10 == 7L) or (min % 10 == 8L) or (min % 10 == 9L) or ((min > 10L) and (min < 20L))) "дней" else if ((min % 10 == 2L) or (min % 10 == 3L) or (min % 10 == 4L)) "дня" else "день"}"
        in 0..1 -> res = "только что"
        in 1..45 -> res = "несколько секунд назад"
        in 45..75 -> res = "минуту назад"
        in 75..45 * 60 -> res =
            "$min ${if ((min % 10 == 0L) or (min % 10 == 5L) or (min % 10 == 6L) or (min % 10 == 7L) or (min % 10 == 8L) or (min % 10 == 9L) or ((min > 10L) and (min < 20L))) "минут" else if ((min % 10 == 2L) or (min % 10 == 3L) or (min % 10 == 4L)) "минуты" else "минуту"} назад"
        in 45 * 60..75 * 60 -> res = "час назад"
        in 75 * 60..22 * 60 * 60 -> res =
            "$hour ${if ((min % 10 == 0L) or (min % 10 == 5L) or (min % 10 == 6L) or (min % 10 == 7L) or (min % 10 == 8L) or (min % 10 == 9L) or ((min > 10L) and (min < 20L))) "часов" else if ((min % 10 == 2L) or (min % 10 == 3L) or (min % 10 == 4L)) "часа" else "час"} назад"
        in 22 * 60 * 60..26 * 60 * 60 -> res = "день назад"
        in 26 * 60 * 60..360 * 24 * 60 * 60 -> res =
            "$day ${if ((min % 10 == 0L) or (min % 10 == 5L) or (min % 10 == 6L) or (min % 10 == 7L) or (min % 10 == 8L) or (min % 10 == 9L) or ((min > 10L) and (min < 20L))) "дней" else if ((min % 10 == 2L) or (min % 10 == 3L) or (min % 10 == 4L)) "дня" else "день"} назад"
        else -> {
            res = when {
                diff > 360 * 24 * 60 * 60 -> "более года назад"
                else -> "более чем через год"
            }
        }
    }
    return res
}
enum class TimeUnits {
    SECOND, MINUTE, HOUR, DAY
}