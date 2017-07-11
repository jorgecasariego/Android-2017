package com.example;

/**
 * Created by jorgecasariego on 8/7/17.
 */

public class Auto extends Vehiculo implements IVehiculo {
    private int numeroAsientos;

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    @Override
    public void imprimir(){
        super.imprimir();
        System.out.println("Numero de asientos es: " + this.numeroAsientos);
    }

    @Override
    public void aceleracion(int velocidad) {
        double aceleracion = velocidad / 10.6;

        System.out.println("La aceleracion del auto de 0 a "
                + velocidad + " es " + String.format("%.2f", aceleracion ) + " segundos");
    }
}
