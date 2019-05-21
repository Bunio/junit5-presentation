package com.onemoreline.calculator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _9_Vintage_Test {

    private final Calculator calculator = new Calculator();

    @Before
    public void vintageBefore() {
        System.out.println("Before!");
    }

    @Test
    public void vintageTest() {
        assertEquals(15, calculator.add(10,5));
    }


    @org.junit.jupiter.api.Test
    public void jupiterTest() {
        assertEquals(15, calculator.add(10,5));
    }



}
