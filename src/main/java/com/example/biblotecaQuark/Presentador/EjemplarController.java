package com.example.biblotecaQuark.Presentador;

import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;
import com.example.biblotecaQuark.Modelo.Libro.Libro;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaDecorador;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsNotNull;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsString;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsint;
import com.example.biblotecaQuark.Presentador.StrategyMsj.ContextMensaje;
import com.example.biblotecaQuark.Presentador.StrategyMsj.Mensajes.MsjLibroDescipcion;
import com.example.biblotecaQuark.Presentador.StrategyMsj.TyposDescripcion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EjemplarController {
    private static Scanner sc = new Scanner(System.in);
    private static List<Libro> libroList = LibroController.getLibroList();
    private static ContextMensaje contextMensaje = new ContextMensaje();

    private static ValidaDecorador validaDecorador;

    public static void addEjempalar(){

        contextMensaje.imprimir(new MsjLibroDescipcion(libroList, TyposDescripcion.LIST_ISNB_LIBRO));
        System.out.println("Seleccione el IBNS que quieres crear su ejemplar");

        int ibns = contextMensaje.respuestaInt();



        String finalIbns = String.valueOf(ibns);
        Libro libroSel = libroList.stream().filter(libro -> Objects.equals(libro.getIBNS(), finalIbns)).toList().get(0);

        if(libroSel != null){

            System.out.println("Ingrese la cantidad de ejemplares que quieres agregar");
            validaDecorador = new ValidaIsint(new ValidaIsNotNull());
            validaDecorador.dateInt(sc.nextLine());
            int cant = validaDecorador.resultInt();

            List<Ejemplar> ejemplarList = libroSel.getEjemplarList();
            int ulNumEd = 0;
            if(!ejemplarList.isEmpty()){
                ulNumEd = ejemplarList.get(libroSel.getEjemplarList().size()-1).getNumEdition();
            }

            System.out.println("Ubicacion de los ejemplares");
            validaDecorador = new ValidaIsString(new ValidaIsNotNull());
            validaDecorador.dateString(sc.nextLine());
            String ubicacion = validaDecorador.resultString();
            for (int i = 0; i < cant; i++){

                ejemplarList.add(new Ejemplar(libroSel, ++ulNumEd, ubicacion));
            }

            int newCant = libroSel.getCantEjemplar() + cant;
            libroSel.setCantEjemplar(newCant);

            libroSel.setEjemplarList(ejemplarList);

        }else{
            System.out.println("libro no encontrado");
        }
    }
    public static List<Ejemplar> listEjemplar(){
        List<Ejemplar> ejemplarList = new ArrayList<>();


        libroList.forEach(libro -> {
            ejemplarList.addAll(libro.getEjemplarList());
        });

        return ejemplarList;


    }

}
