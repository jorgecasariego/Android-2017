package com.example;

public class MyClass {
    public static void main(String[] args) {
        Vehiculo mercedesBenz = new Vehiculo();
        mercedesBenz.setMarca("Mercedez Benz");
        mercedesBenz.imprimir();

        //Aumentar velocidad
        mercedesBenz.aumentarVelocidad();
        mercedesBenz.imprimir();
    }


}
