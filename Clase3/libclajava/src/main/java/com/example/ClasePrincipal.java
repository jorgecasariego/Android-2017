package com.example;

import java.util.Random;

public class ClasePrincipal {
    public static void main(String[] args) {
        //Crear e inicializar un array de 10 enteros
        int cantidad = 10;
        int [] numerosAleatorios = new int[cantidad];

        Random generadorNumeros = new Random();

        //Ejercicio 1
        for (int i = 0; i < numerosAleatorios.length; i++) {
            numerosAleatorios[i] = generadorNumeros.nextInt(100) + 1;
        }

        //Ejercicio 2
        imprimirArray(numerosAleatorios);

        //Ejercicio 3
        int maximo = 0;
        for (int i = 0; i < numerosAleatorios.length; i++) {
            if(numerosAleatorios[i] > maximo){
                maximo = numerosAleatorios[i];
            }
        }

        System.out.println("El numero maximo es " + maximo);

        //Ejercicio 4
        for (int i = 0; i < numerosAleatorios.length/2; i++) {
            int temporal = numerosAleatorios[i];
            numerosAleatorios[i] = numerosAleatorios[cantidad-i-1];
            numerosAleatorios[cantidad-i-1] = temporal;
        }

        //Ejercicio 5
        imprimirArray(numerosAleatorios);

        //Ejercicio 6
        //Manera 1
        int[] nuevoArray = new int[cantidad];
        for (int i = 0; i < numerosAleatorios.length; i++) {
            nuevoArray[i] = numerosAleatorios[i];
        }
        System.out.println("Nuevo array");
        imprimirArray(nuevoArray);

        //Manera 2
        System.out.println("Array clonado");
        nuevoArray = numerosAleatorios.clone();
        imprimirArray(nuevoArray);
    }

    private static void imprimirArray(int[] numerosAleatorios) {
        System.out.println("");
        for (int i = 0; i < numerosAleatorios.length; i++) {
            System.out.print(" " + numerosAleatorios[i]);
        }
        System.out.println("");
    }


}
