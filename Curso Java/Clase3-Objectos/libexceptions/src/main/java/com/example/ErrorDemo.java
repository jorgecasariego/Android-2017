package com.example;

/**
 * Created by jorgecasariego on 8/7/17.
 */

public class ErrorDemo {

    public void metodo1(){
        metodo2();
    }

    public void metodo2(){
        metodo1();
    }
}
