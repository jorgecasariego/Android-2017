package com.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyClass {
    public static void main(String[] args) {

//        int a = 10;
//        int b = 0;
//        int resultado = division(a, b);
//        if(resultado == -1){
//            System.out.println("No trates de dividir por cero");
//        } else {
//            System.out.println("El resultado de la division es " + resultado);
//        }

//        metodo1();
//        System.out.println("Despues del metodo 1");

        Set coleccionEjemplo = new HashSet<Integer>();
        coleccionEjemplo.add(123);
        coleccionEjemplo.add(3);
        coleccionEjemplo.add(65);
        coleccionEjemplo.add(3);

        System.out.println("Coleccion tiene: " + coleccionEjemplo);

        coleccionEjemplo.remove(3);

        System.out.println("Coleccion tiene: " + coleccionEjemplo);

        Iterator i = coleccionEjemplo.iterator();
        while (i.hasNext()){
            System.out.println("Valor es " + i.next());
        }

        //Ejercicio List
        ArrayList listaPersonas = new ArrayList<String>();
        listaPersonas.add("Jorge");
        listaPersonas.add("Maria");
        listaPersonas.add("Jorge");

        System.out.println("Lista es " + listaPersonas);

    }

    private static void metodo1() {
        try {
            metodo2();
        } catch (Exception e){
            System.out.println("Ocurrio un error en el metodo 2");
            e.printStackTrace();
        }

        System.out.println("Despues del metodo 2");
    }

    private static void metodo2() {
        metodo3();
        System.out.println("Despues del metodo 3");
    }

    private static void metodo3() {
        int a, b;

        a= 10;
        b= 0;

        int resultado = a/b;
    }

    private static int division(int a, int b) {
        int c = -1;

        try{
            c =  a/b;
            FileReader fr = new FileReader("test.txt");
        } catch (ArithmeticException e){
            System.out.println("Ocurrio un error de tipo aritmetico");
            //e.printStackTrace();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Primero debe crear el archivo antes de hacer la división");
        } finally {
            System.out.println("Siempre se ejecuta");
        }

        return c;
    }
}
