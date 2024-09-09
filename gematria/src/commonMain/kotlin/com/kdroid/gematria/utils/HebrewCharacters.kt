package com.kdroid.gematria.utils

internal const val GERESH = "׳"
internal const val GERSHAYIM = "״"

private val hebrewToNumMap = mapOf(
    "א" to 1, "ב" to 2, "ג" to 3, "ד" to 4, "ה" to 5, "ו" to 6, "ז" to 7, "ח" to 8, "ט" to 9,
    "י" to 10, "כ" to 20, "ך" to 20, "ל" to 30, "מ" to 40, "ם" to 40, "נ" to 50, "ן" to 50,
    "ס" to 60, "ע" to 70, "פ" to 80, "ף" to 80, "צ" to 90, "ץ" to 90, "ק" to 100, "ר" to 200,
    "ש" to 300, "ת" to 400, "תק" to 500, "תר" to 600, "תש" to 700, "תת" to 800, "תתק" to 900,
    "תתר" to 1000
)

private val validHebrewLetters = hebrewToNumMap.keys

/**
 * Checks if the given character is a valid Hebrew letter.
 */
internal fun isHebrewLetter(char: String): Boolean {
    return char in validHebrewLetters
}

/**
 * Converts an integer to its Hebrew numeric representation.
 */
internal fun numberToHebrew(num: Int): String {
    return hebrewToNumMap.entries.find { it.value == num }?.key ?: "*INVALID*"
}

/**
 * Converts a Hebrew character to its corresponding numeric value.
 */
internal fun numberFromHebrew(hebChar: String): Int {
    return hebrewToNumMap[hebChar] ?: 0
}
