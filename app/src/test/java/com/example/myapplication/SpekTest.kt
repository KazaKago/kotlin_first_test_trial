package com.example.myapplication

import org.junit.Assert.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

// https://www.spekframework.org/
object SpekTest : Spek({
    describe("Spek test description") {
        val hello by memoized { "hello" }

        it("length should return size of string") {
            assertEquals(5, hello.length)
        }
    }
})