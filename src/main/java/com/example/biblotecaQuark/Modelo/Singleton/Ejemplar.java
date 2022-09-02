package com.example.biblotecaQuark.Modelo.Singleton;


import com.example.biblotecaQuark.Modelo.Libro.Libro;

public class Ejemplar {

    private Integer numEdition;
    private static Integer idEdicion = 1;

    private Libro libro;

    public Ejemplar(Libro libro, Integer numEdcion) {
        this.numEdition = numEdcion;
        this.libro = libro;
    }

    public Ejemplar(Libro libro){
        this.libro = libro;
    }

    // GETTER AND SETTER

    public Integer getNumEdition() {
        return numEdition;
    }

    public void setNumEdition(Integer numEdition) {
        this.numEdition = numEdition;
    }

    public static Integer getIdEdicion() {
        return idEdicion;
    }

    public static void setIdEdicion(Integer idEdicion) {
        Ejemplar.idEdicion = idEdicion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

// TOSTRING


    @Override
    public String toString() {
        return "Ejemplar{" +
                "numEdition=" + numEdition +
                ", libro={" + libro.getName() +", "+ libro.getIBNS() +", "+ libro.getAutor()  +
                "} "+
                '}';
    }
}
