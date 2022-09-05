package com.example.biblotecaQuark.Presentador.StrategyMsj;

import com.example.biblotecaQuark.Modelo.Libro.ILibro;
import com.example.biblotecaQuark.Modelo.Libro.Libro;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaDecorador;

import java.util.List;
import java.util.Scanner;

public class MsjLibro extends AbstractMensaje {

    protected List<Libro> libroList;
    protected ValidaDecorador validaDecorador;

    public MsjLibro(){

    }

    @Override
    public void imprimirMensaje() {

    }

    @Override
    public String respuestaString() {
        return null;
    }

    @Override
    public Integer respuestaInt() {
        return null;
    }
}
