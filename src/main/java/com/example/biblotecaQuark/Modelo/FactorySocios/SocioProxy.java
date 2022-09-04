package com.example.biblotecaQuark.Modelo.FactorySocios;

import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;

import java.util.List;

public class SocioProxy extends ISocio {

    private Socio socio;

    public SocioProxy(Socio socio){
        this.socio = socio;
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
    public String getName() {
        return socio.getName();
    }

    @Override
    public void setName(String name) {
        socio.setName(name);
    }

    @Override
    public String getLasName() {
        return socio.getLasName();
    }

    @Override
    public void setLasName(String lasName) {
        socio.setLasName(lasName);
    }

    @Override
    public Integer getId() {
        return socio.getId();
    }

    @Override
    public void setId(Integer id) {
        socio.setId(id);
    }

    @Override
    public List<Ejemplar> getEjemplaresRetirados() {
        return ejemplaresRetirados;
    }

    @Override
    public void setEjemplaresRetirados(List<Ejemplar> ejemplaresRetirados) {
        this.ejemplaresRetirados = ejemplaresRetirados;
    }

    @Override
    public Integer getCantRetirar() {
        return socio.getCantRetirar();
    }

    @Override
    public void setCantRetirar(Integer cantRetirar) {
        socio.setCantRetirar(cantRetirar);
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
