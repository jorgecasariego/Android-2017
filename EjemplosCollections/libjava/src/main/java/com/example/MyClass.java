package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyClass {
    public static void main(String[] args) {
        //Ejercicio 1 = Ejemplo set
        System.out.println("Ejemplo SET");
        ejemploSet();

        System.out.println("");

        //Ejercicio 2 = Ejemeplo List
        System.out.println("Ejemplo List");
        ejemploList();

        System.out.println("");

        //Ejercicio 3 = Ejemplo Map
        System.out.println("Ejemplo Map");
        ejemploMap();

    }

    private static void ejemploMap() {
        HashMap<Integer, String> personas = new HashMap<>();

        personas.put(1234, "Victor");
        personas.put(765, "Raul");
        personas.put(8723, "Alicia");
        personas.put(54231, "Agustina");

        System.out.println(personas);

        System.out.println("La persona con cedula 1234 es " + personas.get(1234));

        personas.remove(765);
        System.out.println(personas);

        System.out.println("Existe la persona llamada Agustina: " + personas.containsValue("Agustina"));

        //Recorremos un Map con las claves
        for(Integer cedula: personas.keySet()){
            System.out.println("Persona --> " + personas.get(cedula));
        }

        //Recorremos un Map con los valores
        for(String nombre: personas.values()){
            System.out.println("Nombre: " + nombre);
        }
    }

    private static void ejemploList() {
        ArrayList<String> ejemplo = new ArrayList<>();
        ejemplo.add("A");
        ejemplo.add("B");
        ejemplo.add("A");
        ejemplo.add("B");
        ejemplo.add("A");

        System.out.println(ejemplo);

        Iterator i = ejemplo.iterator();

        while (i.hasNext()){
            System.out.println("List -> " + i.next());
        }
    }

    /**
     * HashSet is the best performing implementation of Set interface.
     * It stores its elements in a HashTable an does not guarantee of
     * any type of ordering in iteration.
     */
    private static void ejemploSet() {
        Set ejemplo = new HashSet<String>();

        ejemplo.add("Jorge");
        ejemplo.add("Maria");
        ejemplo.add("Juan");
        ejemplo.add("Vivian");

        //Imprimimos los valores
        System.out.println(ejemplo);

        //Iterando una coleccion SET
        Iterator iterator = ejemplo.iterator();
        while (iterator.hasNext()){
            System.out.println("Elemento es: " + iterator.next());
        }

        ejemplo.remove("Juan");
        System.out.println("");

        //Iterando una coleccion SET
        iterator = ejemplo.iterator();
        while (iterator.hasNext()){
            System.out.println("Elemento es: " + iterator.next());
        }

        ejemplo.add("Vivian");
        System.out.println("");

        //Iterando una coleccion SET
        iterator = ejemplo.iterator();
        while (iterator.hasNext()){
            System.out.println("Elemento es: " + iterator.next());
        }

    }
}
