package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculatorKata {

    private StringCalculatorKata() {
    }

    public static int add(String numbers) {
        int sum = 0;
        List<Integer> negativeValues = new ArrayList<>();

        if (numbers == null || numbers.isEmpty()) {
            return sum;
        } else if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);

            // Replace all non-numeric characters in parts[1] with commas
            String cleanedNumbers = parts[1].replaceAll("[^0-9]+", ",");

            // Split cleanedNumbers using comma as a separator
            String[] numberArray = cleanedNumbers.split(",");

            // Sum the numbers
            sum = getSum(numberArray, negativeValues, sum);


        } else if (numbers.contains(",\n")) {
            throw new IllegalArgumentException("Invalid input");
        } else {
            String[] numberArray = numbers.split("[,\n]");
            sum = getSum(numberArray, negativeValues, sum);
        }
        if (!negativeValues.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeValues);
        }

        return sum;
    }

    private static int getSum(String[] numberArray, List<Integer> negativeValues, int sum) {
        for (String number : numberArray) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                negativeValues.add(num);
            } else if (num <= 1000) {
                sum += num;
            }
        }
        return sum;
    }

}

