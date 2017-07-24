package com.example;

/**
 * Created by jorgecasariego on 24/6/17.
 */

public class LoopJava {
    public static void main(String[] args) {

        // Ejemplo Switch
        String diaSemana = "Día del Padre";

        switch (diaSemana){
            case "Lunes":
                diaSemana = "Lunes";
                break;
            case "Martes":
                diaSemana = "Martes";
                break;
            case "Miercoles":
                diaSemana = "Miercoles";
                break;
            case "Jueves":
                diaSemana = "Jueves";
                break;
            case "Viernes":
                diaSemana = "Viernes";
                break;
            case "Sabado":
            case "Domingo":
                diaSemana = "Fin de Semana";
                break;
            default:
                diaSemana = "Feriado";
                break;
        }

        //System.out.println("Hoy es " + diaSemana);

        // Ejemplo While
        int numero = 1234;

        System.out.println("\nNumero es: " + numero);
        while(numero > 0){
            int digito = numero % 10;
            System.out.println("digito es " + digito);

            numero = numero / 10;
        }

        //Ejemplo for
        double porcentaje;
        int suma = 0;
        int total = 100;

        for (int i= 1; i<=100; i++){
            suma += i;
        }

        System.out.println("Suma es " + suma);
        porcentaje = suma / (double)total;

        //Para mas ejemplos mirar: https://dzone.com/articles/java-string-format-examples
        System.out.println("Porcentaje es " + String.format("%.2f", porcentaje));

    }
}
