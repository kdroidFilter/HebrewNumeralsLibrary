package com.kdroid.gematria.converter

import com.kdroid.gematria.utils.toDafAndAmoud
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Converts an integer representing a Daf Gemara (Talmudic page) to its corresponding string representation.
 *
 * This function takes an integer representing a Daf Gemara and converts it to a formatted string. The Daf is represented
 * using Hebrew numerals (Gematria), and the Amoud (side) is determined based on the integer's parity:
 * - An odd integer corresponds to a dot (`.`) for the right-hand side (Amoud Aleph).
 * - An even integer corresponds to a colon (`:`) for the left-hand side (Amoud Bet).
 *
 *
 * @receiver Int The integer representing the Daf Gemara. It should be a non-negative integer.
 * @return A string representing the Daf Gemara in the format "{Daf}{Amoud}", where {Daf} is the Hebrew numeral for the Daf
 *         (with the Daf number incremented by 1) and {Amoud} is either a dot or a colon based on the parity of the input integer.
 *
 * @throws IllegalArgumentException If the integer is negative.
 *
 * @sample
 * // Example usage:
 * val dafGemara = 5.toDafGemara()
 * println(dafGemara) // Outputs "ד." :"
 *
 * val dafGemara2 = 6.toDafGemara()
 * println(dafGemara2) // Outputs "ד:"
 */

fun Int.toDafGemara(): String {
    val (daf, amoud) = this.toDafAndAmoud()
    val amoudSymbol = if (amoud == "a") "." else ":"
    return "${daf.toHebrewNumeral(includeGeresh = false)}$amoudSymbol"
}

