package com.example.biblotecaQuark.Presentador.StrategyMsj.Mensajes;

import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;
import com.example.biblotecaQuark.Presentador.StrategyMsj.MsjEjemplar;
import com.example.biblotecaQuark.Presentador.StrategyMsj.TyposDescripcion;

import java.util.ArrayList;
import java.util.List;

public class MsjEjemplarDescripcion extends MsjEjemplar {

    private TyposDescripcion typosDescripcion;
    private List<Ejemplar> ejemplarList = new ArrayList<Ejemplar>();

    public MsjEjemplarDescripcion( List<Ejemplar> ejemplarList , TyposDescripcion typosDescripcion){
        this.typosDescripcion = typosDescripcion;
        this.ejemplarList = ejemplarList;
    }

    @Override
    public void imprimirMensaje() {
        if(typosDescripcion == TyposDescripcion.LISTI_ISNB_EJEMPLAR){
            listISBN();
        }
    }

    @Override
    public String respuestaString() {
        return this.result;
    }


    private void listISBN(){
        ejemplarList.forEach(ejemplar -> {
            System.out.println("................\n" +
                    "Numero de edicion: "+ejemplar.getNumEdition()+"\n" +
                    "Ubicacion: "+ejemplar.getUbicacion()+"\n" +
                    "................\n");
        });
    }

}
