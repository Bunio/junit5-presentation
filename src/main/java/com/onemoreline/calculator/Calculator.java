package com.onemoreline.calculator;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int div(int a, int b) {
        if(b == 0) {
            throw new IllegalArgumentException("Can not divide by zero!");
        }
        return a / b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int pow(int a, int b) {
        int result = b > 0 ? a : 1;

        while(b > 1) {
            result *= a;
            b -- ;

            try {
                Thread.sleep(1);
            } catch (Exception e) {

            }

        }

        return result;
    }



}
