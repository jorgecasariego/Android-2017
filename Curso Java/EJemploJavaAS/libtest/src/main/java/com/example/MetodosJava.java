package com.example;

/**
 * Created by jorgecasariego on 24/6/17.
 */

public class MetodosJava {
    public static void main(String[] args) {
        int a = 22;
        int b = 12;
        int c = 52;

        encontrarElMenorNumero(a, b, c);

        eficiente(a,b,c);

        funcionesMatematicasJava(a, b, c);
    }

    private static void funcionesMatematicasJava(int a, int b, int c) {
        System.out.println("EL menor es " + Math.min(Math.min(a, b), c));
    }

    private static void eficiente(int a, int b, int c) {
        int menor = a;

        if(menor > b)
            menor = b;

        if(menor > c)
            menor = c;

        System.out.println("El menor es " + menor);
    }

    private static void encontrarElMenorNumero(int a, int b, int c) {
        if(a <= b && a <= c){
            System.out.println("El menor es " + a);
        } else if(b <= c && b < a){
            System.out.println("El menor es " + b);
        } else {
            System.out.println("El menor es " + c);
        }
    }
}
