package com.kdroid.gematria.converter

import com.kdroid.gematria.utils.GERESH
import com.kdroid.gematria.utils.GERSHAYIM
import com.kdroid.gematria.utils.num2heb
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

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
 * Converts an integer to its corresponding Hebrew numeral representation (Gematria).
 *
 * This function is defined as an extension on the `Int` type and converts the integer
 * to a string of Hebrew letters. It handles years in the Hebrew calendar within the
 * current millennium, omitting the thousands digit. For example, for the year 5784,
 * the result will be "תשפ"ד" (without the thousands digit).
 *
 * @receiver Int The numerical value to convert. It must be a non-negative integer.
 * @return A string representing the Hebrew numeral (Gematria) equivalent of the integer.
 *
 * @throws IllegalArgumentException If the integer is negative.
 *
 * @sample
 * // Example usage:
 * val result = 5784.toHebrewNumeral()
 * println(result) // Outputs "תשפ"ד"
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
fun Int.toHebrewNumeral(): String {
    val number = this
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