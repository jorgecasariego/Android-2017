package com.example;

public class MyClass {
    public static void main(String[] args) {
        int a,b;

        a = 10;
        b = 0;

        int resultado = division(a, b);
        System.out.println("El resultado es " + resultado);
    }

    private static int division(int a, int b) {
        return a/b;
    }
}
