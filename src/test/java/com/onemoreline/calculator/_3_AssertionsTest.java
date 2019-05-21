package com.onemoreline.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _3_AssertionsTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void standardAssertions() {
        int a = 4;
        int b = 5;

        assertNotNull(calculator);
        assertTrue(a < b, " B should be bigger !");
        assertEquals(9, calculator.add(a,b));

        // + Others like ...
        // assertSame(), assertNotSame(), assertArrayEquals()...
    }

    // New, very handy method
    @Test
    public void assertThrowsTest() {

        int a = 4;
        int b = 5;

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.div(2, 0)
        );

        assertEquals("Can not divide by zero!", ex.getMessage());

    }

    @Test
    public void assertAllTest() {
        assertAll(
                () -> assertEquals(8, calculator.add(3,5 )),
                () -> assertEquals(2, calculator.add(1,1 )),
                () -> assertEquals(6, calculator.add(3,3 ))
        );
    }

    @Test
    public void assertTimeoutTest() {

        int a = 4;
        int b = 5;
        var maxDuration = Duration.ofMillis(100);

        assertTimeout(
                maxDuration,
                () -> calculator.pow(2, 5)
        );

    }

}
