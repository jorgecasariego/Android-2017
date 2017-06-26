package com.example;

/**
 * Created by jorgecasariego on 24/6/17.
 */

class Numero{
    int x;
}

public class ObjectoNumero {

    public static void main(String[] args) {
        Numero n = new Numero();

        n.x = 3;

        System.out.println("Numero es " + n.x);

        incrementar(n);

        System.out.println("Numero despues de llamar al metodos incrementar es " + n.x);


        //Otro ejemplo
        String mensaje = "Hola";
        System.out.println("Mensaje: " + mensaje);
        masFuerte(mensaje);
        System.out.println("Ahora el mensaje es " + mensaje);
    }

    private static void masFuerte(String mensaje) {
        mensaje.concat(" Mundo!!");
    }

    private static void incrementar(Numero n) {
        System.out.println("Numero antes de incrementar es: " + n.x);

        n.x = n.x + 1;

        System.out.println("El numero despues de incrementar es " + n.x);
    }
}
