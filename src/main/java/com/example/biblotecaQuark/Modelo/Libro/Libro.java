package com.example.biblotecaQuark.Modelo.Libro;

import com.example.biblotecaQuark.Modelo.FactorySocios.ISocio;
import com.example.biblotecaQuark.Modelo.Singleton.Ejemplar;
import com.example.biblotecaQuark.Modelo.Singleton.Prestamo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Libro implements ILibro{
    private String name;
    private String IBNS;
    private String autor;
    private Integer cantEjemplar;
    private Prestamo prestamo;
    private List<Ejemplar> ejemplarList;
    private List<ISocio> socioList = new ArrayList<>();

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
            return ejemplarList.remove(0);
        }
        return null;
    }

    @Override
    public void registrar(Ejemplar ejemplar, ISocio socioRetira) {
        if(ejemplarList.size() < this.cantEjemplar){

            socioList = socioList.stream().filter(socio -> !Objects.equals(socio.getId(), socioRetira.getId())).toList();

            ejemplarList.add(ejemplar);
        }
    }

    @Override
    public Boolean crearISBN(String isbn) {
        if(ISBN.getInstance(isbn).isEmpty()){
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

    public String getIBNS() {
        return IBNS;
    }

    public void setIBNS(String IBNS) {
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


// TO STRING


    @Override
    public String toString() {
        return "Libro{" +
                "name='" + name + '\'' +
                ", IBNS='" + IBNS + '\'' +
                ", autor='" + autor + '\'' +
                ", cantEjemplar=" + cantEjemplar +
                ", prestamo=" + prestamo +
                ", ejemplarList= {" + ejemplarList +"}"+
                ", socioList Saca=" + socioList +
                '}';
    }
}