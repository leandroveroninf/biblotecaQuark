package com.example.biblotecaQuark.Modelo.Interfaces;

import com.example.biblotecaQuark.Modelo.Prestamo.Prestamo;
import com.example.biblotecaQuark.Modelo.Prestamo.PrestamoData;

import java.util.List;

public interface IPrestamo {

    List<PrestamoData> ObtenerPrestamos();

}
