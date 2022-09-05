package com.example.biblotecaQuark.Modelo.Libro;

import com.example.biblotecaQuark.Modelo.FactorySocios.ISocio;


public interface ILibro {

    // para consultar si hay ejemplares disponibles para retirar
    Boolean disponibles();

    // para poder prestar un ejemplar del libro y sacarlo de las lista
    Ejemplar prestar(ISocio socio);

    // Agregamos un libro que fue prestado
    void registrar(Ejemplar ejemplar, ISocio socioRetira);
    //Crear un nuevo ISBN
    Boolean crearISBN(int isbn);

    //Crear
}
