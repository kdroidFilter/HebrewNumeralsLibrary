package com.kdroid.gematria

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class GematriaCaculatorTest {
    @Test
    fun testGematriaCalculator() {

        assertFails {
            gematriaCalculator(-1)
        }
        assertEquals(
            expected = "ה׳",
            actual = gematriaCalculator(5)
        )

        assertEquals(
            expected = "נ׳",
            actual = gematriaCalculator(50)
        )

        assertEquals(
            expected = "תתק״ה",
            actual = gematriaCalculator(905)
        )

        assertEquals(
            expected = "תשפ״ה",
            actual = gematriaCalculator(5785)
        )
    }
}