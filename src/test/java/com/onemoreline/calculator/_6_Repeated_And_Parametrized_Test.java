package com.onemoreline.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _6_Repeated_And_Parametrized_Test {

    private final Calculator calculator = new Calculator();

    @RepeatedTest(value = 5, name = "{currentRepetition} / {totalRepetitions}")
    public void shouldRepeatTest() {
    }

    // Requires junit-jupiter-params
    // Parametrized tests requires source!
    // Multiple sources can be defined

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 6, 7})
    public void intValueSourceTest(int a) {
    }

    // @NullSource provides a single null argument to the annotated @ParameterizedTest method.
    // @NullSource cannot be used for a parameter that has a primitive type.

    // @EmptySource: provides a single empty argument to the annotated @ParameterizedTest method for parameters of the following types:
    // java.lang.String, java.util.List, java.util.Set, java.util.Map, primitive arrays (e.g., int[], char[][], etc.), object arrays
    // (e.g.,String[], Integer[][], etc.).
    // Subtypes of the supported types are not supported.

    // @NullAndEmptySource: a composed annotation that combines the functionality of @NullSource and @EmptySource


    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "xxxx")
    public void nullAndEmptySourceStringTest(String a) {
    }

    // @EnumSource is used to iterate over enums. You can specify some filters eg:
    // names = { "MEDIUM", "WELLDONE" } - picks only selected enums
    // mode = EXCLUDE, names = { "MEDIUM" } - picks all, except selected enums
    // mode = MATCH_ALL, names = "^(M|N).+SECONDS$" - picks all matching given pattern
    @ParameterizedTest
    @EnumSource(value = SteakType.class)
    public void enumSourceTest(SteakType steakType) {

    }

    private enum SteakType {
        RARE, MEDIUM, WELLDONE
    }


    // @MethodSource
    // Factory methods within the test class must be static
    // Each factory method must generate a stream of arguments
    // In this context, a "stream" is anything that JUnit can reliably convert into a Stream, such as Stream, DoubleStream, LongStream, IntStream, Collection, Iterator, Iterable, an array of objects, or an array of primitives

    @ParameterizedTest
    // By default @MethodSource looks for a method with the same name
    @MethodSource
    //@MethodSource("methodSourceListTest")
    //@MethodSource(value = {"methodSourceTest", "methodSourceListTest"})
    public void methodSourceTest(String arg) {

    }

    static List<String> methodSourceListTest() {
        return asList("l_1", "l_2", "l_3");
    }
    static Stream<String> methodSourceTest() {
        return Stream.of("a", "b", "c");
    }


    // If a parameterized test method declares multiple parameters, you need to return a collection, stream, or array
    // of Arguments object instances or object arrays

    @ParameterizedTest
    @MethodSource
    public void methodSourceTestWithMultipleParameters(int a, int b, int expected) {
        Assertions.assertEquals(expected, calculator.mul(a,b));
    }

    static Stream<Arguments> methodSourceTestWithMultipleParameters() {
        return Stream.of(
                arguments(2,3,6),
                arguments(1,2,2)
        );
    }

    static Stream<Object[]> methodSourceTestWithMultipleParametersAsObjArrays() {
        return Stream.of(
                new Object[] {2,3,6},
                new Object[] {1,2,2}
        );
    }

    // An external, static factory method can be referenced by providing its fully qualified method name
    // as demonstrated in the following example.

    @ParameterizedTest
    @MethodSource("com.onemoreline.calculator.SomeParameterFactory#parametersForMethodSourceTestWithExternalParameterFactory")
    public void methodSourceTestWithExternalParameterFactory(int a) {
    }



    @CsvSource({"2,2", "4,3", "6,4", "8,5", "10,6"})
    //@CsvFileSource(resources = "/somecsv.csv")
    @ParameterizedTest
    public void csvParametrizedTest(int a, int b) {

    }

    @ParameterizedTest
    // Arguments source requires class that implements ArgumentsProvider interface with provideArguments method.
    @ArgumentsSource(SomeParameterProvider.class)
    public void argumentsSourceTest(int a) {

    }
}

class SomeParameterFactory {

    static Stream<Integer> parametersForMethodSourceTestWithExternalParameterFactory() {
        return Stream.of(1,2,3,4,5);
    }
}

class SomeParameterProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                arguments(1),
                arguments(2),
                arguments(3)
        );
    }
}

