package com.example;
import java.util.ArrayList;
import java.util.List;

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
            String cleanedNumbers = parts[1].replaceAll("\\D+", ",");
            String[] onlyNumbersArrays = cleanedNumbers.split(",");
            sum = getNumbersSum(onlyNumbersArrays, negativeValues, sum);

        } else if (numbers.contains(",\n")) {
            throw new IllegalArgumentException("Invalid input");
        } else {
            String[] numberArray = numbers.split("[,\n]");
            sum = getNumbersSum(numberArray, negativeValues, sum);
        }
        handleNegativeValues(negativeValues);

        return sum;
    }

    private static void handleNegativeValues(List<Integer> negativeValues) {
        if (!negativeValues.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeValues);
        }
    }

    private static int getNumbersSum(String[] numberArray, List<Integer> negativeValues, int sum) {
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

