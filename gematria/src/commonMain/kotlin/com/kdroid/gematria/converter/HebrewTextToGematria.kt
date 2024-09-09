package com.kdroid.gematria.converter

import com.kdroid.gematria.utils.isHebrewLetter
import com.kdroid.gematria.utils.numberFromHebrew
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Converts a Hebrew string to its corresponding numerical value (Gematria).
 *
 * This function processes each character of the given string, converts valid Hebrew letters
 * to their associated numerical value, and sums them to return the total Gematria value.
 * Non-Hebrew characters (such as spaces, punctuation, or any other symbols) are ignored.
 *
 * @receiver String The Hebrew string to convert. The string may contain non-Hebrew characters, which will be ignored.
 * @return The numerical value (Gematria) of the string, as an integer.
 *
 * @sample
 * // Example usage:
 * val result = "תשפ״ד".toGematria()
 * println(result) // Outputs the integer 784
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
fun String.toGematria(): Int {
    val hebString = this
    var number = 0

    for (char in hebString) {
        val currentChar = char.toString()

        // Ignore spaces and other non-Hebrew characters
        if (!isHebrewLetter(currentChar)) {
            continue
        }

        // Convert Hebrew character to number
        val hebNum = numberFromHebrew(currentChar)

        number += hebNum
    }

    return number
}