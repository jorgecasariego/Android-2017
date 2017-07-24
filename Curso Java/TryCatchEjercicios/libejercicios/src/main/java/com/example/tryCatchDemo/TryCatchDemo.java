package com.example.tryCatchDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by jorgecasariego on 8/7/17.
 *
 * A tener en cuenta que si usamos el ejemplo de la división con double
 * y no con int no nos saltará ninguna exception ya que los enteros en java
 * no soportan valores para +/-infinito, NaN, y no permiten división por 0,
 * mientras que float y double si tienen esos valores especiales
 *
 * Si quieren mas información ir al siguiente link:
 * http://en.wikipedia.org/wiki/IEEE_floating_point
 *
 * - Division by zero (an operation on finite operands gives an exact infinite
 *   result, e.g., 1/0 or log(0)) (returns ±infinity by default).
 */

public class TryCatchDemo {
    public static void main(String[] args) {

        //1. SUpongamos que tenemos que dividir 2 resultados y el resultado guardar en un archivo
        int a = 10;
        int b = 10;



        try {
            int resultado = a/b;
            FileReader fr = new FileReader("test.txt");
        } catch (ArithmeticException e){
            System.out.println("Hubo un error del tipo aritmetico.");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // En ultimo caso declarar Exception por si no se cumplen
            // ninguna de las excepciones anteriores
            System.out.println("muy general el error");
        } finally {
            System.out.println("Se ejecuta de todas maneras");
        }
    }
}
