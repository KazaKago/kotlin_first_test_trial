package com.example.myapplication

import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class MockitoKotlinTest {
    @Test
    fun drive_car() = runTest {
        val car = mock<Car> {
            onBlocking { it.drive(Direction.NORTH) } doReturn Outcome.OK
        }
        car.drive(Direction.NORTH) // returns OK
        verify(car).drive(Direction.NORTH)
    }
}
