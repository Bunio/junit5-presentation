package com.onemoreline.calculator;

import org.junit.jupiter.api.*;
import java.util.Comparator;

//  By default, test methods will be ordered using an algorithm that is deterministic but intentionally nonobvious.
//  Unit tests typically should not rely on the order in which they are executed

// OrderAnnotation  @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// Alphanumeric     @TestMethodOrder(MethodOrderer.Alphanumeric.class)
// Random           @TestMethodOrder(MethodOrderer.Random.class)

// Or define yours:

@TestMethodOrder(MyOrderer.class)
public class _1_Lifecycle_And_Order_Test {


    private final Calculator calculator = new Calculator();

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("BEFORE ALL");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("AFTER ALL");
    }

    @BeforeEach
    void beforeEachTest(TestInfo testInfo) {
        System.out.println("BEFORE EACH : " + testInfo.getDisplayName());
    }

    @AfterEach
    void afterEachTest(TestInfo testInfo) {
        System.out.println("AFTER EACH : " + testInfo.getDisplayName());
    }

    @Test
    public void shouldCalculatePower() {
        Assertions.assertEquals(1, calculator.pow(2, 0));
        Assertions.assertEquals(2, calculator.pow(2, 1));
        Assertions.assertEquals(4, calculator.pow(2, 2));
        Assertions.assertEquals(8, calculator.pow(2, 3));
    }


    // Method orderer tests

    @Test
    public void x_Test() {}

    @Test
    public void z_Test() {}

    @Test
    public void b_Test() {}

    @Test
    public void a_Test() {}

}

// Custom orderer for ordering test methods by method name.

class MyOrderer implements MethodOrderer {
    @Override
    public void orderMethods(MethodOrdererContext methodOrdererContext) {
           methodOrdererContext.getMethodDescriptors().sort(
                   Comparator.comparing(method -> method.getMethod().getName())
           );
    }
}
