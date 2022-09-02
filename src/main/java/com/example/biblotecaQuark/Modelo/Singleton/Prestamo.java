package com.example.biblotecaQuark.Modelo.Singleton;

import com.example.biblotecaQuark.Modelo.FactorySocios.Socio;

import java.util.List;


public class Prestamo {

    private Prestamo prestamo = null;
    private Ejemplar ejemplar;

    private List<Socio> socioList;

    private Prestamo(Ejemplar ej){
        ejemplar = ej;

    }

    public Prestamo getInstance(Ejemplar ejemplar){
        if(prestamo == null){
            prestamo = new Prestamo(ejemplar);
            return prestamo;
        }else{
            return prestamo;
        }
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public List<Socio> getSocioList() {
        return socioList;
    }

    public void setSocioList(List<Socio> socioList) {
        this.socioList = socioList;
    }

    // TO STRING


    @Override
    public String toString() {
        return "Prestamo{" +
                "prestamo=" + prestamo +
                ", ejemplar=" + ejemplar +
                ", socioList=" + socioList +
                '}';
    }
}
