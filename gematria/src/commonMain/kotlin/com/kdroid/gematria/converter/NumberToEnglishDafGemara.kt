package com.kdroid.gematria.converter

import com.kdroid.gematria.utils.toDafAndAmoud

/**
 * Converts an integer representing a Daf Gemara (Talmudic page) to its corresponding English representation.
 *
 * The function takes an integer input and converts it into the format "{Daf}{Amoud}". The Daf is calculated
 * based on the input number, with the Daf numbering starting at 2. The Amoud (side) is determined based on
 * whether the input number is odd or even:
 * - Odd numbers correspond to "a".
 * - Even numbers correspond to "b".
 *
 * @receiver Int The integer representing the Daf Gemara. It must be a non-negative integer.
 * @return A string representing the Daf Gemara in the English format "{Daf}{Amoud}", where {Daf} is the Daf
 *         number starting at 2, and {Amoud} is either "a" or "b" based on the odd/even nature of the input number.
 *
 * @throws IllegalArgumentException If the integer is negative.
 */

fun Int.toEnglishDafGemara(): String {
    val (daf, amoud) = this.toDafAndAmoud()
    return "$daf$amoud"
}
