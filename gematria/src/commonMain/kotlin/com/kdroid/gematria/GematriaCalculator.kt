package com.kdroid.gematria

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

private const val GERESH = "׳"
private const val GERSHAYIM = "״"

fun num2heb(num: Int): String {
    return when (num) {
        1 -> "א"
        2 -> "ב"
        3 -> "ג"
        4 -> "ד"
        5 -> "ה"
        6 -> "ו"
        7 -> "ז"
        8 -> "ח"
        9 -> "ט"
        10 -> "י"
        20 -> "כ"
        30 -> "ל"
        40 -> "מ"
        50 -> "נ"
        60 -> "ס"
        70 -> "ע"
        80 -> "פ"
        90 -> "צ"
        100 -> "ק"
        200 -> "ר"
        300 -> "ש"
        400 -> "ת"
        500 -> "תק"
        600 -> "תר"
        700 -> "תש"
        800 -> "תת"
        900 -> "תתק"
        1000 -> "תתר"
        else -> "*INVALID*"
    }
}

private fun num2digits(number: Int): List<Int> {
    val digits = mutableListOf<Int>()
    var num = number
    while (num > 0) {
        if (num == 15 || num == 16) {
            digits.add(9)
            digits.add(num - 9)
            break
        }
        var incr = 100
        var i = 400
        while (i > num) {
            if (i == incr) {
                incr /= 10
            }
            i -= incr
        }
        digits.add(i)
        num -= i
    }
    return digits
}

/**
 * Converts a numerical value to a string of Hebrew letters according to gematria.
 *
 * This function handles years in the Hebrew calendar within the current millennium. It omits the thousands
 * digit in the representation. For example, for a year in the current millennium like 5784, the result
 * will be "תשפ"ד" (without the thousands digit).
 *
 * @param number The numerical value to convert. It must be a non-negative integer.
 * @return A string representing the value in Hebrew gematria.
 *
 * @throws IllegalArgumentException If the number is negative.
 *
 * @sample
 * // Example usage:
 * val result = gematriaCalculator(5784)
 * println(result) // Outputs "תשפ"ד"
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
fun gematriaCalculator(number: Int): String {
    if (number < 0) {
        throw IllegalArgumentException("The number cannot be negative.")
    }

    val thousands = number / 1000
    var str = ""
    if (thousands > 0 && thousands != 5) {
        val tdigits = num2digits(thousands)
        for (digit in tdigits) {
            str += num2heb(digit)
        }
        str += GERESH
    }
    val digits = num2digits(number % 1000)
    if (digits.size == 1) {
        return "$str${num2heb(digits[0])}$GERESH"
    }
    for ((index, digit) in digits.withIndex()) {
        if (index == digits.lastIndex) {
            str += GERSHAYIM
        }
        str += num2heb(digit)
    }
    return str
}

