package com.kdroid.gematria

import com.kdroid.gematria.converter.toDafGemara
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
        assertEquals(
            expected = 113,
            actual = "אני בן 18 ".toGematria()
        )
    }

    @Test
    fun idToDafGemaraConverter() {
        assertFails {
            (-1).toDafGemara()
        }
        assertEquals(
            expected = "ב.",
            actual = 1.toDafGemara()
        )
        assertEquals(
            expected = "ב:",
            actual = 2.toDafGemara()
        )
        assertEquals(
            expected = "ג.",
            actual = 3.toDafGemara()
        )
        assertEquals(
            expected = "ג:",
            actual = 4.toDafGemara()
        )
        assertEquals(
            expected = "ד.",
            actual = 5.toDafGemara()
        )
        assertEquals(
            expected = "ד:",
            actual = 6.toDafGemara()
        )
        assertEquals(
            expected = "ה.",
            actual = 7.toDafGemara()
        )
        assertEquals(
            expected = "ה:",
            actual = 8.toDafGemara()
        )
        assertEquals(
            expected = "ו.",
            actual = 9.toDafGemara()
        )
        assertEquals(
            expected = "ו:",
            actual = 10.toDafGemara()
        )
        assertEquals(
            expected = "ז.",
            actual = 11.toDafGemara()
        )
        assertEquals(
            expected = "ז:",
            actual = 12.toDafGemara()
        )
        assertEquals(
            expected = "ח.",
            actual = 13.toDafGemara()
        )
        assertEquals(
            expected = "ט.",
            actual = 15.toDafGemara()
        )
        assertEquals(
            expected = "טו.",
            actual = 27.toDafGemara()
        )

    }
}