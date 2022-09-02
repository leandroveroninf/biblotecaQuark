package com.example.biblotecaQuark.Modelo.FactorySocios;


import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;

import java.util.List;

public class SocioVIP extends ISocio{

    private Double cuetaMensual = 0D;
    public SocioVIP(String name, String lasName, Integer id){
        this.name = name;
        this.lasName = lasName;
        this.id = id;
        this.cantRetirar = 3;
    }

    public Double getCuetaMensual() {
        return cuetaMensual;
    }

    public void setCuetaMensual(Double cuetaMensual) {
        this.cuetaMensual = cuetaMensual;
    }

    @Override
    public String toString() {
        return "SocioVIP{" +
                "cuetaMensual=" + cuetaMensual +
                ", name='" + name + '\'' +
                ", lasName='" + lasName + '\'' +
                ", id=" + id +
                ", ejemplaresRetirados=" + ejemplaresRetirados +
                ", cantRetirar=" + cantRetirar +
                '}';
    }

    @Override
    List<Ejemplar> listEjemplares() {
        return null;
    }
}
