package com.ecpe205;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {
    Calculator calc;

    @BeforeAll
    void setup() {
        calc = new Calculator();
    }

    //CREATE A TEST TO TEST isEven
    @Test
    void shouldCheckValueIsEven() {
        assertEquals(true, calc.isEven(2));
        assertEquals(false, calc.isEven(1));
    }

    @Test
    void shouldCheckValueIsOdd() {
        assertEquals(true, calc.isOdd(1));
        assertEquals(false, calc.isOdd(2));
    }


    @Test
    @DisplayName("Sum 2 encoded values")
    void shouldSumTwoEncodedValues() {

        // 1 + 2 = 3
        assertEquals(3, calc.sum(1, 2));
        assertEquals(9, calc.sum(5, 4));
        assertEquals(5, calc.sum(3, 2));
        assertEquals(14, calc.sum(5, 9));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void shouldSumValueWithOne(int value) {
        assertEquals(value + 1, calc.sum(value, 1));
    }

    @ParameterizedTest
    @MethodSource("sumInputValues")
    void shouldSumTwoInputValues(int a, int b) {
        assertEquals(a + b, calc.sum(a, b));
    }

    static Stream<Arguments> sumInputValues() {
        return Stream.of(
                Arguments.of(1, 2),
                Arguments.of(4, 6),
                Arguments.of(2, 7),
                Arguments.of(3, 7),
                Arguments.of(3, 0)
        );
    }

    static Stream<Arguments> arrayOfIntegerSets() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 1}),
                Arguments.of(new int[]{7, 1, 5, 4, 1}),
                Arguments.of(new int[]{7, 2, 8, 3, 4})
        );
    }

    //Test for Exponent
    @ParameterizedTest
    @MethodSource("useBaseXPowerY")
    void shouldSolveExponent(double a, double b) {
        assertEquals(Math.pow(a, b), calc.exponent(a, b));
    }

    static Stream<Arguments> useBaseXPowerY() {
        return Stream.of(
                Arguments.of(5, 2),
                Arguments.of(6, 4),
                Arguments.of(2, 3),
                Arguments.of(9, 2),
                Arguments.of(1, 0)
        );
    }

    //Test for Factorial
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void shouldSolveFactorial(int n) {
        assertEquals(6, calc.factorial(n));
    }

    //Test for Palindrome
    @ParameterizedTest
    @ValueSource(strings = {"civic", "level", "valorant", "madam", "repaper"})
    void shouldKnowIfStringIsPalindrome(String n) {
        assertEquals(true, calc.isPalindrome(n));
    }

    //Test for Sorting
    @ParameterizedTest
    @MethodSource("arrayOfInteger")
    void shouldSortArray(int[] array) {
        assertEquals(calc.bubbleSort(array));
    }

    static Stream<Arguments> arrayOfInteger () {
        return Stream.of(
                Arguments.of(new int[]{4, 1, 3, 5, 2}),
                Arguments.of(new int[]{22, 1, 45, 23, 15}),
                Arguments.of(new int[]{6, 8, 9, 7, 10}),
                Arguments.of(new int[]{55, 22, 44, 77, 88}),
                Arguments.of(new int[]{2, 1, 15, 11, 3})

        );
    }
}
