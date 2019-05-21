package com.onemoreline.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class _4_Assumptions_Test {

    private static final Calculator calculator = null;

    // Assumptions are meant to check certain conditions, not the code itself
    // If assumeTrue condition is not met, test is ignored instead of failed

    @Test
    public void assumeTrueTest() {
        assumeTrue(calculator != null);
        assertEquals(2, calculator.add(1,1));
    }

    @Test
    public void assumeThatTest() {
        assumingThat(
                calculator != null,
                () -> assertEquals(2, calculator.add(1,1))
        );
    }


}
