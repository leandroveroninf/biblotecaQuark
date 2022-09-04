package com.example.biblotecaQuark.Modelo.Libro;


import com.example.biblotecaQuark.Modelo.Libro.Libro;

public class Ejemplar {

    private Integer numEdition;

    private Libro libro;

    private String ubicacion;

    public Ejemplar(Libro libro, Integer numEdcion, String ubicacion) {
        this.numEdition = numEdcion;
        this.libro = libro;
        this.ubicacion = ubicacion;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // TOSTRING


    @Override
    public String toString() {

        return "\n------------------\n" +
                "numedo de edicion: "+numEdition+"\n" +
                "Ubicacion: "+ ubicacion+ "\n" +
                "pertenece al libro: Name -> \t\t"+ libro.getName() +", Autor -> "+ libro.getAutor() +", INBS-> "+ libro.getIBNS() +"\n"+
                "------------------\n";

    }
}
