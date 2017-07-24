package com.example;

/**
 * Created by jorgecasariego on 24/6/17.
 */

public class MasChico {
    public static void main(String[] args) {
        int numero1 = 432;
        int numero2 = 432;
        int numero3 = 562;

        int resultado = encontrarNumeroMasChico(numero1, numero2, numero3);

        System.out.println("EL menor es " + resultado);

        int resultado2 = mameraCorta(numero1, numero2, numero3);
        System.out.println("El menor2 es " + resultado2);
    }

    private static int mameraCorta(int a, int b, int c) {
        int menor = a;

        if(menor > b)
            menor = b;

        if(menor > c)
            menor = c;

        return menor;
    }

    private static int encontrarNumeroMasChico(int a, int b, int c) {
        int menor = 0;

        if(a <= b && a <= c){
            menor = a;
        } else if(b <= a && b <= c){
            menor = b;
        } else {
            menor = c;
        }

        return menor;
    }

}
