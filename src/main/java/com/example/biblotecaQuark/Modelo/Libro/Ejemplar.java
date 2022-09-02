package com.example.biblotecaQuark.Modelo.Libro;


import com.example.biblotecaQuark.Modelo.Libro.Libro;

public class Ejemplar {

    private Integer numEdition;

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
