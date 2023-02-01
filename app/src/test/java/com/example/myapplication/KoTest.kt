package com.example.myapplication

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldHaveLength
import io.kotest.matchers.string.startWith
import io.kotest.property.checkAll
import io.kotest.property.forAll

// https://kotest.io/
class KoTest : StringSpec({
    "length should return size of string" {
        "hello".length shouldBe 5
    }
    "startsWith should test for a prefix" {
        "world" should startWith("wor")
    }
    "String size by forAll" {
        forAll<String, String> { a, b ->
            println("a = $a, b = $b")
            (a + b).length == a.length + b.length
        }
    }
    "String size" {
        checkAll<String, String> { a, b ->
            a + b shouldHaveLength a.length + b.length
        }
    }
})
