package com.kdroid.gematria.utils

/**
 * Internal function to calculate the Daf number and Amoud side (a or b).
 *
 * @receiver Int The integer representing the Daf Gemara.
 * @return A Pair where the first element is the Daf (as an integer),
 *         and the second element is the Amoud side ("a" or "b").
 */
internal fun Int.toDafAndAmoud(): Pair<Int, String> {
    if (this < 0) {
        throw IllegalArgumentException("The Daf Gemara ID cannot be negative.")
    }
    val daf = when {
        (this == 1) -> 2
        (this % 2 == 0) -> (this / 2) + 1
        else -> ((this + 1) / 2) + 1
    }
    val amoud = if (this % 2 == 1) "a" else "b"
    return Pair(daf, amoud)
}