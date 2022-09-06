package com.example.biblotecaQuark.Modelo.Libro;

import com.example.biblotecaQuark.Modelo.FactorySocios.ISocio;
import com.example.biblotecaQuark.Modelo.Prestamo.PrestamoTypo;
import com.example.biblotecaQuark.Modelo.Singleton.ISBN;
import com.example.biblotecaQuark.Modelo.Prestamo.Prestamo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Libro implements ILibro{
    private String name;
    private int IBNS;
    private String autor;
    private Integer cantEjemplar;
    private Prestamo prestamo;
    private List<Ejemplar> ejemplarList = new ArrayList<Ejemplar>();
    private List<ISocio> socioList = new ArrayList<ISocio>();
    private String ubicacion;

    public Libro(String name, String autor) {
        this.name = name;
        this.autor = autor;
    }

    public Libro(){

    }

    @Override
    public Boolean disponibles() {
        return !ejemplarList.isEmpty();
    }

    @Override
    public Ejemplar prestar(ISocio socio) {
        if(this.disponibles() && socio.cupo()){
            socioList.add(socio);
            Ejemplar ejemplar = ejemplarList.remove(0);
            prestamo = new Prestamo(ejemplar, socio);
            prestamo.tipoOperacion(PrestamoTypo.PRESTADO);
            return ejemplar;
        }
        return null;
    }

    @Override
    public void registrar(Ejemplar ejemplar, ISocio socioRetira) {
        if(ejemplarList.size() < this.cantEjemplar){

            List<ISocio> s = socioList.stream().filter(socio -> !Objects.equals(socio.getId(), socioRetira.getId())).toList();
            socioList = new ArrayList<>(s);
            prestamo = new Prestamo(ejemplar, socioRetira);
            prestamo.tipoOperacion(PrestamoTypo.DEVUELTO);
            ejemplarList.add(ejemplar);
        }
    }

    @Override
    public Boolean crearISBN(int isbn) {
        if(!ISBN.getInstance(isbn)){
            return false;
        }
        this.IBNS = isbn;
        return true;
    }


    // GETTER AND SETTER


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIBNS() {
        return IBNS;
    }

    public void setIBNS(int IBNS) {
        this.IBNS = IBNS;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getCantEjemplar() {
        return cantEjemplar;
    }

    public void setCantEjemplar(Integer cantEjemplar) {
        this.cantEjemplar = cantEjemplar;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public List<Ejemplar> getEjemplarList() {
        return ejemplarList;
    }

    public void setEjemplarList(List<Ejemplar> ejemplarList) {
        this.ejemplarList = ejemplarList;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    // TO STRING


    @Override
    public String toString() {

        return "\n*****************************************\n" +
                "name: "+name+"\n" +
                "autor: "+autor +"\n"+
                "IBNS: "+IBNS+"\n" +
                "Cantidad de ejemplares disponibles: "+ ( cantEjemplar - socioList.size()) +"\n" +
                "Ejemplares: -> \t\t"+ejemplarList+"\n" +
                "Prestado a los soscios: -> \t\t"+socioList+"\n" +
                "*****************************************\n";
    }
}
