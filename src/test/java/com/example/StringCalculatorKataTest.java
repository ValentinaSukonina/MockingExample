package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorKataTest {

    @Test
    @DisplayName("Given string containing two numbers return their sum")
    void givenStringContainingTwoNumbersReturnTheirSum() {
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

    
}









