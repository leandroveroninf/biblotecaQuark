package com.example.biblotecaQuark.Modelo.FactorySocios;


import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;

import java.util.List;

public class Socio extends ISocio{

    public Socio(String name, String lasName, Integer id){
        this.name = name;
        this.lasName = lasName;
        this.id = id;
        this.cantRetirar = 1;
    }

    public Socio(){

    }

    // TO STRING
    @Override
    public String toString() {

        return "\n-----------------------------\n" +
                "SOCIO" +"\n"+
                "id: "+ id + "\n"+
                "name: "+ name +"\n" +
                "lasName: "+ lasName +"\n" +
                "Cantidad que puede retirar: "+cantRetirar +"\n"+
                "Ejemplares Retirados: -> \t\t "+ ejemplaresRetirados+"\n" +
                "-----------------------------\n";


    }

    @Override
    List<Ejemplar> listEjemplares() {

        return null;
    }
}
