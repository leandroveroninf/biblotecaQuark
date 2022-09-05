package com.example.biblotecaQuark.Presentador.StrategyMsj.Mensajes;

import com.example.biblotecaQuark.Presentador.StrategyMsj.MsjEjemplar;
import com.example.biblotecaQuark.Presentador.StrategyMsj.TyposDescripcion;

public class MsjEjemplarDescripcion extends MsjEjemplar {

    private TyposDescripcion typosDescripcion;

    public MsjEjemplarDescripcion(TyposDescripcion typosDescripcion){
        this.typosDescripcion = typosDescripcion;
    }

    @Override
    public void imprimirMensaje() {

    }

    @Override
    public String respuestaString() {
        return this.result;
    }



}
