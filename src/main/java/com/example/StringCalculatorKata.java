package com.example;


public class StringCalculatorKata {


    private StringCalculatorKata() {
    }

    public static int add(String numbers){
        int sum = 0;

        if (numbers == null || numbers.isEmpty()){
            return sum;
        } else if (
                numbers.contains(",\n")) {
            throw new IllegalArgumentException("Invalid input");
        } else {String[] numberArray = numbers.split("[,\n]");
            for (String number : numberArray) {
                sum += Integer.parseInt(number);
            }
        }
        return sum;
    }
}

