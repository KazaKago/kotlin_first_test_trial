package com.example.myapplication

import org.amshove.kluent.invoking
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldThrow
import org.junit.Test

class KluentTest {
    @Test
    fun addition_isCorrect() {
        4 shouldBeEqualTo 2 + 2
    }

    @Test
    fun exception() {
        invoking { requireNotNull(null) } shouldThrow IllegalArgumentException::class
    }
}