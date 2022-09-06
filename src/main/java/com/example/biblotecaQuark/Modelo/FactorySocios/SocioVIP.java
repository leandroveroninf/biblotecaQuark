package com.example.biblotecaQuark.Modelo.FactorySocios;


import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;

import java.util.List;

public class SocioVIP extends ISocio{

    private int cuetaMensual = 0;
    public SocioVIP(String name, String lasName, Integer id){
        this.name = name;
        this.lasName = lasName;
        this.id = id;
        this.cantRetirar = 3;
    }

    public int getCuetaMensual() {
        return cuetaMensual;
    }

    public void setCuetaMensual(int cuetaMensual) {
        this.cuetaMensual = cuetaMensual;
    }

    @Override
    public String toString() {

        return "\n-----------------------------\n" +
                "SOCIO VIP" +"\n"+
                "id: "+ id +"\n"+
                "name: "+ name +"\n" +
                "lasName: "+ lasName +"\n" +
                "cuetaMensual=" + cuetaMensual +"\n"+
                "Cantidad que puede retirar: "+cantRetirar +"\n"+
                "Ejemplares Retirados "+ ejemplaresRetirados+"\n" +
                "-----------------------------\n";

    }

    @Override
    List<Ejemplar> listEjemplares() {
        return null;
    }
}
