package com.example;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by jorgecasariego on 24/6/17.
 */

public class ArrayJava {
    public static void main(String[] args) {
        //Ejercicio 1
        int n = 10;
        int[] numerosAleatorios = new int[n];
        Random rand = new Random();
        int maximo = 0;

        for (int i = 0; i < numerosAleatorios.length; i++) {
            numerosAleatorios[i] = rand.nextInt(100) + 1;
        }

        System.out.println("Numeros aleatorios: " + Arrays.toString(numerosAleatorios));

        //Ejercicio 2
        for (int i = 0; i < numerosAleatorios.length; i++) {
            System.out.print(numerosAleatorios[i] + " ");
        }

        System.out.println("");

        //Ejercicio 3
        for (int i = 0; i < numerosAleatorios.length; i++) {
            if(numerosAleatorios[i] > maximo) {
                maximo = numerosAleatorios[i];
            }
        }

        System.out.println("El numero maximo es " + maximo);

        // Rever de numbers
        int cantidad = numerosAleatorios.length;
        for (int i = 0; i < cantidad / 2; i++) {
            int temporal = numerosAleatorios[i];
            numerosAleatorios[i] = numerosAleatorios[cantidad-i-1];
            numerosAleatorios[cantidad-i-1] = temporal;
        }

        System.out.println("Numeros ahora es: " + Arrays.toString(numerosAleatorios));

        //Copiar valores a otro array
        int nuevoarray[] = new int[cantidad];
        for (int i = 0; i < numerosAleatorios.length; i++) {
            nuevoarray[i] = numerosAleatorios[i];
        }

        System.out.println("Nuevo array es: " + Arrays.toString(nuevoarray));

        //Otra manera de copiar es
        nuevoarray = numerosAleatorios.clone();
        System.out.println("Nuevo array es: " + Arrays.toString(nuevoarray));

        numerosAleatorios[0] = 111;
        System.out.println("Nuevo array es de vuelta: " + Arrays.toString(nuevoarray));

        //Problema de copiar de esta manera es que copiamos la referencia y no los valores
        nuevoarray = numerosAleatorios;
        System.out.println("Nuevo array es: " + Arrays.toString(nuevoarray));
        numerosAleatorios[0] = 888;
        System.out.println("Nuevo array es: " + Arrays.toString(nuevoarray));

        int[] array1 = {2, 4, 6, 8, 10};
        int[] array2 = array1;
        array1[0] = 0;
        System.out.println("Array 2 pos 0 es " + array2[0]);
    }
}
