package com.example;

/**
 * Created by jorgecasariego on 1/7/17.
 */

public class Caja {
    private double ancho;
    private double alto;
    private double largo;

    public double getAncho(){
        return ancho;
    }

    public double getAlto(){
        return alto;
    }

    public double getLargo(){
        return largo;
    }

    public void setAncho(double nuevoAncho){
        ancho = nuevoAncho;
    }

    public void setAlto(double nuevoAlto){
        alto = nuevoAlto;
    }

    public void setLargo(double nuevoLargo){
        largo = nuevoLargo;
    }
}
