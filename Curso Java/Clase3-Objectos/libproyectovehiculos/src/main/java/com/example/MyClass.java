package com.example;

public class MyClass {
    public static void main(String[] args) {
        Vehiculo mercedesBenz = new Vehiculo();
        mercedesBenz.setMarca("Mercedez Benz");
        mercedesBenz.imprimir();
        mercedesBenz = null;

        //Aumentar velocidad
        mercedesBenz.aumentarVelocidad();
        mercedesBenz.imprimir();

        Vehiculo fiat = new Vehiculo(100, 3);
        fiat.setMarca("Fiat");
        fiat.imprimir();

        //Creamos un auto
        Auto kiaRio = new Auto();
        kiaRio.setMarca("Kia Rio 2017");
        kiaRio.setNumeroAsientos(4);
        kiaRio.setCambio(1);
        kiaRio.setVelocidad(40);
        kiaRio.imprimir();
        kiaRio.aceleracion(100);

        Tractor tractor = new Tractor();
        tractor.setMarca("John Deere");
        tractor.setCambio(1);
        tractor.setVelocidad(10);
        tractor.setPeso(4500);
        tractor.imprimir();
        tractor.aceleracion(100);

        mercedesBenz.imprimir();
    }


}
