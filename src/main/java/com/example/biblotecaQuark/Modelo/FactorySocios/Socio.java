package com.example.biblotecaQuark.Modelo.FactorySocios;


import com.example.biblotecaQuark.Modelo.Singleton.Ejemplar;

import java.util.List;
import java.util.Objects;

public class Socio extends ISocio{

    public Socio(String name, String lasName, Integer id){
        this.name = name;
        this.lasName = lasName;
        this.id = id;
        this.cantRetirar = 1;
    }

    public Socio(){

    }

    @Override
    public Ejemplar devolverEjemplar(String codIBNS){

        if(!this.ejemplaresRetirados.isEmpty()){
            for(int i = 0; i < ejemplaresRetirados.size(); i++){
                if(Objects.equals(ejemplaresRetirados.get(i).getLibro().getIBNS(), codIBNS)){
                    return ejemplaresRetirados.remove(i);
                }
            }
        }

        return null;
    }


    // TO STRING
    @Override
    public String toString() {
        return "Socio{" +
                "name='" + name + '\'' +
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
