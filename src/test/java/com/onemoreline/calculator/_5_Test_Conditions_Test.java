package com.onemoreline.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _5_Test_Conditions_Test {

    private final Calculator calculator = new Calculator();

    // The ExecutionCondition extension API in JUnit Jupiter allows developers to either enable or disable tests/classes

    @Test
    public void notSkippedTest() {
        Assertions.assertEquals(6, calculator.add(2,4));
    }

    // This test will be skipped
    // Message can be passed to annotation to override default skip message
    // Junit 4 had 	@Ignore annotation instead

    @Test
    @Disabled
    public void skippedTest() {
        Assertions.assertEquals(6, calculator.add(2,4));
    }

    // ------------------------------------------------------------------------------------

    // Two variants: @EnabledOnOs and @DisabledOnOs
    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void shouldBeDisabledOnSomeOperatingSystems() {
        Assertions.assertEquals(6, calculator.add(2,4));
    }

    // Two variants : @EnabledOnJre and @DisabledOnJre
    @Test
    @EnabledOnJre({JRE.JAVA_10})
    public void shouldBeDisabledOnSomeJREs() {
        Assertions.assertEquals(6, calculator.add(2,4));
    }

    // Two variants : @EnabledIfSystemProperty and @DisabledIfSystemProperty
    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void shouldRunOnlyOn64BitArchitectures() {
        Assertions.assertEquals(6, calculator.add(2,4));
    }

    // NOTE : Requires restart
    // Two variants : @EnabledIfEnvironmentVariable and @DisabledIfEnvironmentVariable
    @Test
    @EnabledIfEnvironmentVariable(named = "SOME_VAR", matches = "123")
    void shouldRunOnlyWhenSomeEnvVariableIsSet() {
        Assertions.assertEquals(6, calculator.add(2,4));
    }


    // ------------------------------------------------------------------------------------

    // Scripts can be written in JavaScript, Groovy, or any other scripting language
    // for which there is support for the Java Scripting API, defined by JSR 223

    @Test
    @EnabledIf("1 + 1 == 2 ")
    void shouldRunIfOnePlusOneIsTwo() {
        Assertions.assertEquals(6, calculator.add(2,4));
    }


    @Test
    @EnabledIf(value = {
            "var a = 5",
            "var b = 3",
            "a + b == 2"
    },
            engine = "nashorn",
            reason = "WHOOPS ! : {result}"
    )
    void shouldRunIfAPlusBIsEight() {
        Assertions.assertEquals(6, calculator.add(2,4));
    }


}
