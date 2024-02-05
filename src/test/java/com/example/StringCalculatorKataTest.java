package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorKataTest {
    @Test
    @DisplayName("Given string containing two numbers return their sum")
    void givenStringContainingTwoNumbersReturnTheirSum1() {
        var result = StringCalculatorKata.add("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Given empty string return Zero")
    void givenEmptyStringReturnZero() {
        var result = StringCalculatorKata.add("");

        assertThat(result).isZero();
    }

    @Test
    @DisplayName("String can be split with comma and newLine")
    void stringCanBeSplitWithCommaAndNewLine() {
        var result = StringCalculatorKata.add("1\n2,3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Empty line after last number in String throws IllegalArgumentException")
    void emptyLineAfterLastNumberInStringThrowIllegalArgumentException() {
        String invalidInput = "1,\n";

        IllegalArgumentException exception;
        exception = assertThrows(IllegalArgumentException.class, () -> StringCalculatorKata.add(invalidInput));

        assertEquals("Invalid input", exception.getMessage());
    }

    @Test
    @DisplayName("Double slash change delimiter to Semicolon")
    void doubleSlashChangeDelimiterToSemicolon() {
        var result = StringCalculatorKata.add("//;\n1;2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Negative numbers in comma separated array throw an exception")
    void negativeNumbersInCommaSeparatedArrayThrowAnException() {
        String invalidInput = "-1,2,3,-4";

        IllegalArgumentException exception;
        exception = assertThrows(IllegalArgumentException.class, () -> StringCalculatorKata.add(invalidInput));

        assertEquals("Negatives not allowed: [-1, -4]", exception.getMessage());
    }

    @Test
    @DisplayName("Negative numbers in newLine separated array throw an Exception")
    void negativeNumbersInNewLineSeparatedArrayThrowAnException() {
        String invalidInput = "1\n-2,3,-4";

        IllegalArgumentException exception;
        exception = assertThrows(IllegalArgumentException.class, () -> StringCalculatorKata.add(invalidInput));

        assertEquals("Negatives not allowed: [-2, -4]", exception.getMessage());
    }

    @DisplayName("Numbers bigger than Thousand are ignored in sum calculation")
    @ParameterizedTest
    @CsvSource({
            "'1,1001,3', 4",
            "'1,1000,3', 1004",
            "'1\n2,1001,3', 6",
            "'1\n2,1000,3', 1006",
            "'//;\n1;2;1001', 3",
            "'//;\n1;2;1000', 1003",
            "'//[**]\n2**2**1001', 4",
            "'//[**]\n2**2**1000', 1004",
            "'//[*][%]\n1*2%1001', 3",
            "'//[*][%]\n1*2%1000', 1003"
    })
    void numbersBiggerThanThousandAreIgnoredInSumCalculation(String numbers, int expected) {
        //var result = dataString.add(numbers);
        var result = StringCalculatorKata.add(numbers);
        assertEquals(expected, result);
    }

    @DisplayName("Delimiters of different length allowed with Double Slash")
    @ParameterizedTest
    @CsvSource({
            "'//[**]\n2**2**3', 7",
            "'//[***]\n2***2***3', 7",
            "'//[****]\n2****2****3', 7"

    })
    void delimitersOfDifferentLengthAllowedWithDoubleSlash(String numbers, int expected) {
        var result = StringCalculatorKata.add(numbers);

        assertEquals(expected, result);
    }

    @DisplayName("Multiple delimiters are allowed")
    @ParameterizedTest
    @CsvSource({
            "'//[*][%]\n1*2%3', 6",
            "'//[ * ][ % ]\n1 * 2 % 3', 6",

    })
    void multipleDelimitersAreAllowed(String numbers, int expected) {
        var result = StringCalculatorKata.add(numbers);

        assertEquals(expected, result);
    }

    @DisplayName("Multiple delimeters with length longer then one char are allowed")
    @ParameterizedTest
    @CsvSource({
            "'//[***][%%]\n1***1%%1', 3",
            "'//[ ? ][%%]\n1 ? 1%%1', 3",
            "'//[***][^^]\n1***1^^1', 3"
    })

    void multipleDelimetersWithLengthLongerThenOneCharAreAllowed(String numbers, int expected) {
        var result = StringCalculatorKata.add(numbers);

        assertEquals(expected, result);
    }
}











