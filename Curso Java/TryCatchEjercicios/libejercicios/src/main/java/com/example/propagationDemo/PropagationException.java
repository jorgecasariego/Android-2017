package com.example.propagationDemo;

/**
 * Created by jorgecasariego on 8/7/17.
 */

public class PropagationException {
    public void metodo1(){

        try {
            metodo2();
        } catch (Exception e){
            System.out.println("Ocurrio un error no reconocido");
        }

        System.out.println("DEspues de completarse la llamada al metodo 2");

    }

    public void metodo2(){
        metodo3();
    }

    public void metodo3(){
        int a = 7;
        int b = 0;

        int resultado = a/b;
    }
}
