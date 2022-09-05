package com.example.biblotecaQuark.Modelo.FactorySocios;

import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;
import com.example.biblotecaQuark.Modelo.Prestamo.Prestamo;
import com.example.biblotecaQuark.Modelo.Prestamo.PrestamoTypo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public abstract class ISocio {

    protected String name;
    protected String lasName;
    protected Integer id;

    protected List<Ejemplar> ejemplaresRetirados = new ArrayList<Ejemplar>();
    protected Integer cantRetirar;

    // Retorana true si hay cupos disponibles
    public Boolean cupo(){
        return cantRetirar > 0;
    }

    // Pedir un ejemplar
    public void pedirEjemplar(Ejemplar ejemplar){
        if(this.cupo()){
            this.cantRetirar--;
            Prestamo prestamo = new Prestamo(ejemplar, this);
            prestamo.tipoOperacion(PrestamoTypo.PRESTADO);
            this.ejemplaresRetirados.add(ejemplar);
        }
    }

    // Devolvemos el ejemplar
    public Ejemplar devolverEjemplar(int codIBNS){

        if(!this.ejemplaresRetirados.isEmpty()){
            for(int i = 0; i < ejemplaresRetirados.size(); i++){
                if(ejemplaresRetirados.get(i).getLibro().getIBNS() == codIBNS){

                    Ejemplar ejemplar = ejemplaresRetirados.remove(i);

                    Prestamo prestamo = new Prestamo(ejemplar, this);
                    prestamo.tipoOperacion(PrestamoTypo.DEVUELTO);

                    return ejemplar;
                }
            }
        }

        return null;
    }

    abstract List<Ejemplar> listEjemplares();

    // GETTER AND SETTER


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Ejemplar> getEjemplaresRetirados() {
        return ejemplaresRetirados;
    }

    public void setEjemplaresRetirados(List<Ejemplar> ejemplaresRetirados) {
        this.ejemplaresRetirados = ejemplaresRetirados;
    }

    public Integer getCantRetirar() {
        return cantRetirar;
    }

    public void setCantRetirar(Integer cantRetirar) {
        this.cantRetirar = cantRetirar;
    }
}
