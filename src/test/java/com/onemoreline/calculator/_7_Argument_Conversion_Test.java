package com.onemoreline.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

public class _7_Argument_Conversion_Test {

    // More here
    // https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-argument-conversion

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void shouldConvertIntToOtherTypes(float a) {
        System.out.println(a);
    }

    @ParameterizedTest
    @CsvSource(value = {"2017-03-14", "2017-03-15"})
    public void shouldConvertStringToLocalDate(LocalDate localDate)
    {
        System.out.println(localDate);
    }

}
