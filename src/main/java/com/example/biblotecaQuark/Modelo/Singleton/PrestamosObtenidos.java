package com.example.biblotecaQuark.Modelo.Singleton;

import com.example.biblotecaQuark.Modelo.Interfaces.IPrestamo;
import com.example.biblotecaQuark.Modelo.Prestamo.Prestamo;
import com.example.biblotecaQuark.Modelo.Prestamo.PrestamoData;

import java.util.ArrayList;
import java.util.List;

public class PrestamosObtenidos implements IPrestamo {

    private static List<PrestamoData> prestamoData;
    private static PrestamosObtenidos prestamosObtenidos;

    private PrestamosObtenidos(){
        prestamoData = new ArrayList<>();
    }

    public static PrestamosObtenidos getInstance(PrestamoData prestamo){
        if(prestamosObtenidos == null){
            prestamosObtenidos = new PrestamosObtenidos();
        }else{
            prestamoData.add(prestamo);
        }

        return prestamosObtenidos;
    }

    @Override
    public List<PrestamoData> ObtenerPrestamos() {
        return prestamoData;
    }
}
