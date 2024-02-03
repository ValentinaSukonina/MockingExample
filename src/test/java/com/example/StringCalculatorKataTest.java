package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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



}






