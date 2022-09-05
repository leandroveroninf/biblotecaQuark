package com.example.biblotecaQuark.Presentador.StrategyMsj.Mensajes;

import com.example.biblotecaQuark.Modelo.Libro.ILibro;
import com.example.biblotecaQuark.Modelo.Libro.Libro;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaDecorador;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsNotNull;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsString;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsint;
import com.example.biblotecaQuark.Presentador.StrategyMsj.MsjLibro;
import com.example.biblotecaQuark.Presentador.StrategyMsj.TyposDescripcion;

import java.util.List;

public class MsjLibroDescipcion extends MsjLibro {

    public MsjLibroDescipcion(List<Libro> libroList, TyposDescripcion typosDescripcion){
        this.libroList = libroList;
        this.typosDescripcion = typosDescripcion;
    }

    @Override
    public void imprimirMensaje() {


        if(typosDescripcion == TyposDescripcion.LIST_ISNB_LIBRO){
            this.resultInt = imprimeISBN_Libro();
        }

    }

    @Override
    public String respuestaString() {
        return result;
    }

    @Override
    public Integer respuestaInt(){
        return resultInt;
    }

    private int imprimeISBN_Libro(){

        validaDecorador = new ValidaIsint( new ValidaIsNotNull());

        System.out.println("Seleccione el 'ISNB' del libro");
        libroList.forEach(libro -> {
            System.out.println("********************************\n" +
                    "-> Libro \n" +
                    "\t\t Name: " + libro.getName()+"\n"+
                    "\t\t Codigo INBS: "+ libro.getIBNS() +"\n"+
                    "\t\t Cant ejemplares: "+libro.getCantEjemplar()+"\n" +
                    "********************************\n");
        });
        System.out.print("-> ");
        validaDecorador.dateInt(sc.nextLine());

        return validaDecorador.resultInt();
    }

}
