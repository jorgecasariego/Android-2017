package jorgecasariego.ejerciciosrecyclerviews.modelo;

/**
 * Created by jorgecasariego on 3/8/17.
 */

public class Version {
    private String nombre;
    private int idImagen;

    public Version(String nombre, int idImagen) {
        this.nombre = nombre;
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }
}
