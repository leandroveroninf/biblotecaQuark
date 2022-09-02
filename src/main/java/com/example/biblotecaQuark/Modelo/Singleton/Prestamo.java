package com.example.biblotecaQuark.Modelo.Singleton;

import com.example.biblotecaQuark.Modelo.FactorySocios.ISocio;
import com.example.biblotecaQuark.Modelo.FactorySocios.Socio;
import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;

import java.util.List;


public class Prestamo {

    private static Prestamo prestamo = null;
    private static Ejemplar ejemplar;
    private static ISocio socio;

    private static List<Socio> socioList;

    private Prestamo(Ejemplar ej, ISocio socio){
        ejemplar = ej;

    }

    public static Prestamo getInstance(Ejemplar ejemplar, ISocio socio){
        if(prestamo == null){
            prestamo = new Prestamo(ejemplar, socio);
            return prestamo;
        }else{
            return prestamo;
        }
    }



    // TO STRING


    @Override
    public String toString() {
        return "Prestamo{" +
                "prestamo=" + prestamo +
                ", ejemplar=" + ejemplar +
                ", socioList=" + socioList +
                '}';
    }
}
