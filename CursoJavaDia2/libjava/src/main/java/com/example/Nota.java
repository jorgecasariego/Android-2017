package com.example;

/**
 * Created by jorgecasariego on 24/6/17.
 */

public class Nota {
    public static void main(String[] args) {
        int calificacion1 = 10;
        int calificacion2 = 30;
        int calificacion3 = 43;

        /*
                si nota >= 90 --> A
                si nota >= 70 && nota < 90 --> B
                si nota >= 50 && nota < 70 --> C
                si nota < 50 --> F
         */

        int sumaCalificaciones = calificacion1+calificacion2+calificacion3;
        String letra;
        if(sumaCalificaciones>= 90){
            letra = "A";
        } else if(sumaCalificaciones >= 70 && sumaCalificaciones < 90){
            letra = "B";
        } else if(sumaCalificaciones >= 50 && sumaCalificaciones < 70) {
            letra = "C";
        } else {
            letra = "F";
        }

        System.out.println("TU nota es " + letra);
    }
}
