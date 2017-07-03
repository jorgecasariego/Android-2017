package com.example;

/**
 * Created by jorgecasariego on 1/7/17.
 */

public class Vehiculo {
    private int velocidad;
    private int cambio;
    private String marca;

    public Vehiculo() {
        velocidad = 10;
        cambio = 1;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getCambio() {
        return cambio;
    }

    public void setCambio(int cambio) {
        this.cambio = cambio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void aumentarVelocidad(){
        velocidad = velocidad + 10;
        cambio = cambio + 1;
    }

    public void imprimir(){
        System.out.println("Marca: " + marca + " - Velocidad : " + velocidad + " - Cambio: " + cambio);
    }
}
