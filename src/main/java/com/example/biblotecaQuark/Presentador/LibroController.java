package com.example.biblotecaQuark.Presentador;

import com.example.biblotecaQuark.Modelo.FactorySocios.ISocio;
import com.example.biblotecaQuark.Modelo.FactorySocios.SocioProxy;
import com.example.biblotecaQuark.Modelo.FactorySocios.SocioVIP;
import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;
import com.example.biblotecaQuark.Modelo.Libro.Libro;
import com.example.biblotecaQuark.Presentador.Decorador.*;
import com.example.biblotecaQuark.Presentador.StrategyMsj.ContextMensaje;
import com.example.biblotecaQuark.Presentador.StrategyMsj.Mensajes.MsjLibroDescipcion;
import com.example.biblotecaQuark.Presentador.StrategyMsj.MsjSocio;
import com.example.biblotecaQuark.Presentador.StrategyMsj.Mensajes.MsjSocioDescripcion;
import com.example.biblotecaQuark.Presentador.StrategyMsj.TyposDescripcion;

import java.util.*;

public class LibroController {
    private static List<Libro> libroList = new ArrayList<Libro>();
    private static Scanner sc = new Scanner(System.in);

    private static ContextMensaje contextMensaje = new ContextMensaje();
    private static ValidaDecorador validaDecorador;


    // Para crear los libros
    public static void dataLibro(){
        int cantLicbos = cantLibro();

        validaDecorador = new ValidaIsString(new ValidaIsNotNull());

        for(int n = 0; n < cantLicbos; n++) {

            String name;
            String autor;
            int IBNS;
            int cantEjem = 0;
            String ubicacion;


            System.out.println("Libro ----");
            System.out.print("-> name: ");
            validaDecorador.dateString(sc.nextLine());
            name = validaDecorador.resultString();

            System.out.print("-> autor: ");
            validaDecorador.dateString(sc.nextLine());
            autor = validaDecorador.resultString();

            System.out.print("Ubicacion de los ejempalres: ");
            validaDecorador.dateString(sc.nextLine());
            ubicacion = validaDecorador.resultString();

            validaDecorador = new ValidaIsint(new ValidaIsNotNull());

            System.out.print("-> IBNS: ");
            validaDecorador.dateInt(sc.nextLine());
            IBNS = validaDecorador.resultInt();

            System.out.print("Cantidad de ejemlates: ");

            validaDecorador.dateInt(sc.nextLine());
            cantEjem = validaDecorador.resultInt();


            createLibro(name, autor, ubicacion, IBNS, cantEjem);



        }

    }

    private static void createLibro(String name, String autor, String ubicacion, int INBS, int cantEjm){
        Libro libro = new Libro(name, autor);
        boolean atISBN = libro.crearISBN(INBS);
        validaDecorador = new ValidaIsint(new ValidaIsNotNull());
        while(!atISBN){
            System.out.print("-> IBNS: ");
            validaDecorador.dateInt(sc.nextLine());
            INBS = validaDecorador.resultInt();
            atISBN = libro.crearISBN(INBS);
        }

        libro.setCantEjemplar(cantEjm);


        List<Ejemplar> ejemplarList = new ArrayList<>();

        for (int i = 0; i < libro.getCantEjemplar(); i++) {
            ejemplarList.add(new Ejemplar(libro, (i+1), ubicacion));

        }

        libro.setEjemplarList(ejemplarList);

        libroList.add(libro);

        System.out.println("LIBRO CREADO");
    }

    private static Integer cantLibro(){

        validaDecorador = new ValidaIsint(new ValidaIsNotNull());
        int cant;

        System.out.print("Cantidad de libros: ");
        validaDecorador.dateInt(sc.nextLine());
        cant = validaDecorador.resultInt();


        return cant;
    }


    public static void devolverLibro(){
        socioSelcDevolver(filterSocioVIPCom());
    }

    public static void prestarLibro(){
        List<ISocio> socioList = filterSocioVIPCom();
        int socio = selcSocio(socioList);
        libSelecion(socio, socioList);

    }

    // Private



    private static void libSelecion(int opSocId, List<ISocio> socioList){
        contextMensaje.imprimir(new MsjLibroDescipcion(libroList, TyposDescripcion.LIST_ISNB_LIBRO));
        int opcLibro = contextMensaje.respuestaInt();

        socioList.forEach(socio -> {
            if(socio.getId() == opSocId){
                Optional<Libro> libroOptional = libroList.stream().filter(libro -> libro.getIBNS() == opcLibro).findAny();

                if(socio.cupo()) {


                    if (libroOptional.isPresent()) {
                        libroOptional.ifPresent(libro -> socio.pedirEjemplar(libro.prestar(socio)));
                        System.out.println("Libro prestado a: " + socio.getName() + " " + socio.getLasName());
                    }
                }else{
                    System.out.println("No puede retirar el ejemplar ya que no tiene mas cupos");
                }

            }
        });
    }

    private static List<ISocio> filterSocioVIPCom(){
        contextMensaje.imprimir(new MsjSocio());
        int opcSc = contextMensaje.respuestaInt();

        System.out.println("Seleccione un ID");
        List<ISocio> filter;
        if(opcSc == 1){
            filter = SocioController.getSocioList().stream().filter(socio -> socio instanceof SocioProxy).toList();

        }else{
            filter = SocioController.getSocioList().stream().filter(socioVIP -> socioVIP instanceof SocioVIP).toList();
        }

        return filter;
    }

    private static void socioSelcDevolver(List<ISocio> socioList){

        int opSocId = selcSocio(socioList);

        socioList.forEach(socio -> {
            if(socio.getId() == opSocId){

                if(socio instanceof SocioVIP) {
                    contextMensaje.imprimir(new MsjSocioDescripcion(socio, TyposDescripcion.LIST_ISNB_SOCIO_DEVOLVER));

                    int ibnsSel = contextMensaje.respuestaInt();


                    libroList.forEach(libro -> {
                        if(libro.getIBNS() == ibnsSel){
                            Ejemplar ejemplar = socio.devolverEjemplar(ibnsSel);
                            System.out.println("Ejemplar devuelto\n" +
                                    "\t\t Edicion: "+ejemplar.getNumEdition());

                            libro.registrar(ejemplar, socio);

                        }
                    });

                }else{
                    assert socio instanceof SocioProxy;
                    SocioProxy socioProxy = (SocioProxy) socio;
                    Ejemplar ejemplar = socioProxy.devolverEjemplar();
                    System.out.println("Ejemplar devuelto\n" +
                            "\t\t Edicion: "+ejemplar.getNumEdition());
                    libroList.forEach(libro -> libro.registrar(ejemplar, socio));
                }

            }
        });

    }

    private static int selcSocio(List<ISocio> socioList){
        contextMensaje.imprimir(new MsjSocioDescripcion(socioList, TyposDescripcion.LIST_DESCRIPCION_SOCIO));

        return contextMensaje.respuestaInt();
    }



    public static List<Libro> getLibroList() {
        return libroList;
    }

    public static void setLibroList(List<Libro> libroList) {
        LibroController.libroList = libroList;
    }
}
