package com.example;

public class StringCalculatorKata {
    private static int sum;

    public static int add(String numbers){

        if (numbers == null || numbers.isEmpty()){
            sum = 0;
        } else {
            String[] numberArray = numbers.split(",");
            for (String number : numberArray) {
                sum += Integer.parseInt(number);
            }
        }
        return sum;
    }
}
