package com.example.biblotecaQuark.Modelo.FactorySocios;

import com.example.biblotecaQuark.Modelo.Singleton.Ejemplar;

import java.util.List;

public class SocioProxy extends ISocio {

    private Socio socio;

    public SocioProxy(ISocio socio){
        this.socio = (Socio) socio;
    }

    public Ejemplar devolverEjemplar(){
        String ibns = socio.getEjemplaresRetirados().get(0).getLibro().getIBNS();
        return socio.devolverEjemplar(ibns);
    }

    @Override
    List<Ejemplar> listEjemplares() {
        return null;
    }
}
