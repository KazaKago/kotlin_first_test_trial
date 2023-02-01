package com.example.myapplication

import ch.tutteli.atrium.api.fluent.en_GB.toBeGreaterThan
import ch.tutteli.atrium.api.fluent.en_GB.toBeLessThan
import ch.tutteli.atrium.api.verbs.expect
import org.junit.Test

class AtriumTest {
    @Test
    fun test() {
        expect(4 + 6) {
            toBeLessThan(5)
            toBeGreaterThan(10)
        }
    }
}