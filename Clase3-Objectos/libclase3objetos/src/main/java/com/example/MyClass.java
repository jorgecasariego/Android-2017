package com.example;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("Clase 3 - Objetos");

        Caja cajaAmazon = new Caja();
        imprimirCaja(cajaAmazon);

        cambiarValoresCaja(cajaAmazon);
        imprimirCaja(cajaAmazon);

        //Obtener le volumen de la caja
        System.out.println("El volumen es " + obtenerVolumen(cajaAmazon));
    }

    private static double obtenerVolumen(Caja cajaAmazon) {
        return cajaAmazon.getAlto() * cajaAmazon.getAncho() * cajaAmazon.getAncho();
    }

    private static void cambiarValoresCaja(Caja cajaAmazon) {
        cajaAmazon.setAncho(10);
        cajaAmazon.setLargo(5);
        cajaAmazon.setAlto(4);
    }

    private static void imprimirCaja(Caja caja) {
        System.out.println("Valores");
        System.out.println("Ancho:  " + caja.getAncho());
        System.out.println("Alto: " + caja.getAlto());
        System.out.println("Largo: " + caja.getLargo());
    }
}
