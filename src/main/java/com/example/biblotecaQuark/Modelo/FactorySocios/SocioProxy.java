package com.example.biblotecaQuark.Modelo.FactorySocios;

import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;

import java.util.List;

public class SocioProxy extends ISocio {

    private Socio socio;

    public SocioProxy(ISocio socio){
        this.socio = (Socio) socio;
        this.id = socio.id;
        this.name = socio.name;
        this.lasName = socio.lasName;
        this.ejemplaresRetirados = socio.ejemplaresRetirados;
        this.cantRetirar = socio.cantRetirar;
    }

    public Ejemplar devolverEjemplar(){
        String ibns = socio.getEjemplaresRetirados().get(0).getLibro().getIBNS();
        return socio.devolverEjemplar(ibns);
    }

    @Override
    public void pedirEjemplar(Ejemplar ejemplar){
        socio.pedirEjemplar(ejemplar);
    }


    @Override
    List<Ejemplar> listEjemplares() {
        return null;
    }

    @Override
    public String toString() {
        return this.socio.toString();
    }
}
