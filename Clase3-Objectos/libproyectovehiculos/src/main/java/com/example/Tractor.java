package com.example;

/**
 * Created by jorgecasariego on 8/7/17.
 */

public class Tractor extends Vehiculo implements IVehiculo{
    private int peso;

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void imprimir(){
        super.imprimir();
        System.out.println("Peso es: " + this.peso);
    }

    @Override
    public void aceleracion(int velocidad) {
        double aceleracion = velocidad / 0.6;

        System.out.println("La aceleracion del tractor de 0 a "
                + velocidad + " es " + String.format("%.2f", aceleracion ) + " segundos");
    }
}
