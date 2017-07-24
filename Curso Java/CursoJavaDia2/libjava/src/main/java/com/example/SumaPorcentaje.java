package com.example;

/**
 * Created by jorgecasariego on 24/6/17.
 */

public class SumaPorcentaje {
    public static void main(String[] args) {

        int numero = 100;
        int suma = 0;
        double porcentaje = 0;

        for (int i = 1; i <= numero; i++) {
            suma = suma + i;
        }

        System.out.println("La suma es " + suma);

        porcentaje = suma / (double)100;
        System.out.println("El porcentaje es " + String.format("%.2f",porcentaje));
    }
}
