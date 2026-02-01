package com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {

        if (op.equals("add") || op.equals("add-again")) {
            return a + b;
        } 
        else if (op.equals("sub") || op.equals("sub-again")) {
            return a - b;
        } 
        else if (op.equals("mul")) {
            return a * b;
        } 
        else if (op.equals("div")) {
            if (b == 0) {
                return 0;
            }
            return a / b;
        } 
        else if (op.equals("mod")) {
            return a % b;
        } 
        else if (op.equals("pow")) {
            int result = 1;
            for (int i = 0; i < b; i++) {
                result *= a;
            }
            return result;
        }

        return 0;
    }

    public int addNumbers(int x, int y) {
        return x + y;
    }

    public int sumValues(int a, int b) {
        return a + b;
    }

    public int addAgain(int a, int b) {
        return a + b;
    }
}
