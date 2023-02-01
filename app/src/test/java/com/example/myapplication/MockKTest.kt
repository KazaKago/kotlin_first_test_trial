package com.example.myapplication

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.amshove.kluent.internal.assertEquals
import org.junit.Test

enum class Outcome { OK, NG, }
enum class Direction { NORTH, SOUTH, WEST, EAST, }

class Car {
    suspend fun drive(direction: Direction): Outcome {
        delay(1000)
        return if (direction == Direction.NORTH) Outcome.OK
        else Outcome.NG
    }
}

class MockKTest {
    @Test
    fun drive_car() = runTest {
        val car = mockk<Car> {
            coEvery { drive(Direction.NORTH) } returns Outcome.OK
        }
        car.drive(Direction.NORTH) // returns OK
        coVerify { car.drive(Direction.NORTH) }
    }
}

class Device(
    val type: Type,
    val developer: DevelopBy,
) {
    fun isMobileDevice() = (type == Type.Mobile)
}

enum class Type { Mobile, PC }
enum class DevelopBy { Google, Apple, Microsoft }

class MockKTest2 {
    @Test
    fun filter_developer() = runTest {
        val android = Device(
            type = Type.Mobile,
            developer = mockk(), // もしisMobileDevice()でdeveloperにアクセスしているとテストが落ちる
        )
        assertEquals(android.isMobileDevice(), true)
    }
}