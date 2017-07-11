package com.example.propagationDemo;

/**
 * Created by jorgecasariego on 8/7/17.
 */

public class Principal {
    public static void main(String[] args) {
        PropagationException ejemplo = new PropagationException();

        /*
            Un ejemplo de java.lang.RuntimeException es  NullPointerException, que ocurre cuando un
            método intenta acceder a un miembro de un objeto a través de una referencia nula.

            Esta excepción puede ocurrir en cualquier lugar en que un programa intente desreferenciar
            una referencia a un objeto. Frecuentemente el coste de chequear estas excepciones sobrepasa
            los beneficios de capturarlas.
         */
        ejemplo = null;

        ejemplo.metodo1();

        System.out.println("Despues de completarse el metodo 1");
    }
}
