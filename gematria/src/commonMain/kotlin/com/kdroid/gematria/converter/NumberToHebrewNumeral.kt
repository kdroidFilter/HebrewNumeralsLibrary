package com.kdroid.gematria.converter

import com.kdroid.gematria.utils.GERESH
import com.kdroid.gematria.utils.GERSHAYIM
import com.kdroid.gematria.utils.numberToHebrew
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

private fun numberTodigits(number: Int): List<Int> {
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
 * This function converts the integer to a string of Hebrew letters. It handles years in the Hebrew calendar within the
 * current millennium, omitting the thousands digit if necessary. The function can include or exclude the `GERESH` and
 * `GERSHAYIM` symbols based on the `includeGeresh` parameter.
 *
 * @receiver Int The numerical value to convert. It must be a non-negative integer.
 * @param includeGeresh A Boolean flag that determines whether to include the `GERESH` (׳) and `GERSHAYIM` (״) symbols in the output.
 *                       Default is `true`, meaning these symbols will be included.
 * @return A string representing the Hebrew numeral (Gematria) equivalent of the integer. The result may include or exclude
 *         the `GERESH` and `GERSHAYIM` symbols based on the `includeGeresh` parameter.
 *
 * @throws IllegalArgumentException If the integer is negative.
 *
 * @sample
 * // Example usage with symbols:
 * val resultWithSymbols = 5784.toHebrewNumeral()
 * println(resultWithSymbols) // Outputs "תשפ"ד"
 *
 * // Example usage without symbols:
 * val resultWithoutSymbols = 5784.toHebrewNumeral(false)
 * println(resultWithoutSymbols) // Outputs "תשפד"
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
fun Int.toHebrewNumeral(includeGeresh: Boolean = true): String {
    val number = this
    if (number < 0) {
        throw IllegalArgumentException("The number cannot be negative.")
    }

    val thousands = number / 1000
    var str = ""
    if (thousands > 0) {
        val tdigits = numberTodigits(thousands)
        for (digit in tdigits) {
            str += numberToHebrew(digit)
        }
        if (includeGeresh) {
            str += GERESH
        }
    }
    val digits = numberTodigits(number % 1000)
    if (digits.size == 1) {
        return if (includeGeresh) {
            "$str${numberToHebrew(digits[0])}$GERESH"
        } else {
            "$str${numberToHebrew(digits[0])}"
        }
    }
    for ((index, digit) in digits.withIndex()) {
        if (index == digits.lastIndex && includeGeresh) {
            str += GERSHAYIM
        }
        str += numberToHebrew(digit)
    }
    return str
}
