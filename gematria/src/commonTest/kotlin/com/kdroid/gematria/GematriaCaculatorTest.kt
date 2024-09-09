package com.kdroid.gematria

import com.kdroid.gematria.converter.toGematria
import com.kdroid.gematria.converter.toHebrewNumeral
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class GematriaCaculatorTest {

    @Test
    fun numberToHebrewNumeralConverter() {
        assertFails {
            (-1).toHebrewNumeral()
        }
        assertEquals(
            expected = "ה׳",
            actual = 5.toHebrewNumeral()
        )

        assertEquals(
            expected = "נ׳",
            actual = 50.toHebrewNumeral()
        )

        assertEquals(
            expected = "תתק״ה",
            actual = 905.toHebrewNumeral()
        )

        assertEquals(
            expected = "תשפ״ה",
            actual = 5785.toHebrewNumeral()
        )
    }

    @Test
    fun textToHebrewGematriaConverter(){
        assertEquals(
            expected = 0,
            actual = "".toGematria()
        )

        assertEquals(
            expected = 784,
            actual = "תשפד".toGematria()
        )

        assertEquals(
            expected = 515,
            actual = "ואתחנן ".toGematria()
        )

    }
}