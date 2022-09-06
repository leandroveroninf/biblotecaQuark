package com.example.biblotecaQuark.Presentador;

import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;
import com.example.biblotecaQuark.Modelo.Libro.Libro;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaDecorador;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsNotNull;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsString;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsint;
import com.example.biblotecaQuark.Presentador.StrategyMsj.ContextMensaje;
import com.example.biblotecaQuark.Presentador.StrategyMsj.Mensajes.MsjEjemplarDescripcion;
import com.example.biblotecaQuark.Presentador.StrategyMsj.Mensajes.MsjLibroDescipcion;
import com.example.biblotecaQuark.Presentador.StrategyMsj.TyposDescripcion;

import java.util.*;

public class EjemplarController {
    private static Scanner sc = new Scanner(System.in);
    private static List<Libro> libroList = LibroController.getLibroList();
    private static ContextMensaje contextMensaje = new ContextMensaje();

    private static ValidaDecorador validaDecorador;

    public static void addEjempalar(){

        System.out.println("Seleccione el IBNS que quieres crear su ejemplar");
        contextMensaje.imprimir(new MsjLibroDescipcion(libroList, TyposDescripcion.LIST_ISNB_LIBRO));


        int ibns = contextMensaje.respuestaInt();



        int finalIbns = ibns;
        Libro libroSel = libroList.stream().filter(libro -> libro.getIBNS() == finalIbns).toList().get(0);

        if(libroSel != null){

            System.out.println("Ingrese la cantidad de ejemplares que quieres agregar");
            System.out.print("-> ");
            validaDecorador = new ValidaIsint(new ValidaIsNotNull());
            validaDecorador.dateInt(sc.nextLine());
            int cant = validaDecorador.resultInt();

            List<Ejemplar> ejemplarList = libroSel.getEjemplarList();
            int ulNumEd = 0;
            String ubicacion = null;
            if(!ejemplarList.isEmpty()){
                ulNumEd = ejemplarList.get(libroSel.getEjemplarList().size()-1).getNumEdition();
                ubicacion = ejemplarList.get(libroSel.getEjemplarList().size()-1).getUbicacion();
            }

            if(ubicacion == null){
                boolean ubi = true;
                do {

                    System.out.print("Ubicacion de los ejempalres: ");
                    validaDecorador = new ValidaIsString(new ValidaIsNotNull());
                    validaDecorador.dateString(sc.nextLine());
                    ubicacion = validaDecorador.resultString();

                    String finalUbicacion = ubicacion;
                    Optional<Libro> libroOptional = libroList.stream().filter(libro1 -> Objects.equals(libro1.getUbicacion(), finalUbicacion)).findAny();
                    if(libroOptional.isPresent()){
                        ubi = false;
                    }
                }while(ubi);
            }

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

    public static void mostrarEjemplaresDelLibro(){
        contextMensaje.imprimir(new MsjLibroDescipcion(libroList, TyposDescripcion.LIST_ISNB_LIBRO));
        int opcLibro = contextMensaje.respuestaInt();


        libroList.forEach(libro -> {
            if(libro.getIBNS() == opcLibro){
                contextMensaje.imprimir(new MsjEjemplarDescripcion(libro.getEjemplarList(), TyposDescripcion.LISTI_ISNB_EJEMPLAR));
            }
        });



    }
    public static List<Ejemplar> listEjemplar(){
        List<Ejemplar> ejemplarList = new ArrayList<>();


        libroList.forEach(libro -> {
            ejemplarList.addAll(libro.getEjemplarList());
        });

        return ejemplarList;


    }

}
