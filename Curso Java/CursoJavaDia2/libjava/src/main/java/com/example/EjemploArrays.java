package com.example;

import java.util.Random;

/**
 * Created by jorgecasariego on 24/6/17.
 */

public class EjemploArrays {
    public static void main(String[] args) {
        int cantidad = 10;
        int[] numerosAleatorios = new int[cantidad];

        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            int numAleatorio = random.nextInt(100) + 1;
            numerosAleatorios[i] = numAleatorio;
        }

        for (int i = 0; i < numerosAleatorios.length; i++) {
            System.out.println(" - " + numerosAleatorios[i]);
        }

    }
}
