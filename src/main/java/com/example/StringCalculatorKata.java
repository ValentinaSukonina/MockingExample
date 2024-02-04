package com.example;


import java.util.ArrayList;
import java.util.List;

public class StringCalculatorKata {

    private StringCalculatorKata() {
    }

    public static int add(String numbers){
        int sum = 0;
        List<Integer> negativeValues = new ArrayList<>();

        if (numbers == null || numbers.isEmpty()){
            return sum;
        } else if (
                numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            String[] numberArray = parts[1].split(";");

            for (String number : numberArray) {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    negativeValues.add(num);
                } else if (num <= 1000) {
                    sum += num;
                }
            }
        } else if (
                numbers.contains(",\n")) {
            throw new IllegalArgumentException("Invalid input");
        } else {String[] numberArray = numbers.split("[,\n]");
            for (String number : numberArray) {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    negativeValues.add(num);                    
                } else if (num <= 1000) {
                    sum += num;
                }
            }
        }
        if (!negativeValues.isEmpty()){
            throw new IllegalArgumentException("Negatives not allowed: " + negativeValues);
        }

        return sum;
    }
}

