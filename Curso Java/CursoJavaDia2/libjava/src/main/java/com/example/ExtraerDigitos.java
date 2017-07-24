package com.example;

/**
 * Created by jorgecasariego on 24/6/17.
 */

public class ExtraerDigitos {
    public static void main(String[] args) {

        int numero = 12435;

        System.out.println("Numero inicialmente es : " +numero);

        while(numero > 0){
            int digito = numero % 10;
            System.out.println(" Digito es: " + digito);

            numero = numero / 10;
        }

    }
}
