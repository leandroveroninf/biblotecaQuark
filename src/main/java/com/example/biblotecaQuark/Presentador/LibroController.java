package com.example.biblotecaQuark.Presentador;

import com.example.biblotecaQuark.Modelo.FactorySocios.ISocio;
import com.example.biblotecaQuark.Modelo.FactorySocios.Socio;
import com.example.biblotecaQuark.Modelo.FactorySocios.SocioProxy;
import com.example.biblotecaQuark.Modelo.FactorySocios.SocioVIP;
import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;
import com.example.biblotecaQuark.Modelo.Libro.Libro;
import com.example.biblotecaQuark.Modelo.Prestamo.Prestamo;
import com.example.biblotecaQuark.Modelo.Prestamo.PrestamoTypo;
import com.example.biblotecaQuark.Presentador.StrategyMsj.ContextMensaje;
import com.example.biblotecaQuark.Presentador.StrategyMsj.MsjSocio;
import com.example.biblotecaQuark.Presentador.StrategyMsj.MsjSocioDescripcion;
import com.example.biblotecaQuark.Presentador.StrategyMsj.TyposDescripcion;

import java.util.*;

public class LibroController {
    private static List<Libro> libroList;
    private static Scanner sc = new Scanner(System.in);

    private static ContextMensaje contextMensaje = new ContextMensaje();

    // Para crear los libros
    public static void dataLibro(){
        libroList = new ArrayList<>();
        System.out.println("Cantidad de libros");
        System.out.print("-> ");
        int cantLicbos = 1;
        cantLicbos = sc.nextInt();

        for(int n = 0; n < cantLicbos; n++) {
            System.out.println("Libro ----");
            sc.nextLine();
            System.out.println("-> name");
            System.out.print("-> ");
            String nombre = sc.nextLine();
            System.out.println("-> autor");
            System.out.print("-> ");
            String autor = sc.nextLine();
            System.out.println("-> IBNS");
            System.out.print("-> ");
            String ibns = sc.nextLine();
            System.out.println("Cantidad de ejemlates");
            System.out.print("-> ");
            Integer cantEjm = sc.nextInt();
            System.out.println("Ubicacion de los ejempalres");
            System.out.print("-> ");
            sc.nextLine();
            String ubicacion = sc.nextLine();

            Libro libro = new Libro(nombre, autor);
            boolean atISBN = libro.crearISBN(ibns);
            while(!atISBN){
                System.out.println("-> IBNS");
                System.out.print("-> ");
                sc.nextLine();
                ibns = sc.nextLine();
                atISBN = libro.crearISBN(ibns);
            }

            libro.setCantEjemplar(cantEjm);


            List<Ejemplar> ejemplarList = new ArrayList<>();

            for (int i = 0; i < libro.getCantEjemplar(); i++) {
                ejemplarList.add(new Ejemplar(libro, (i+1), ubicacion));

            }

            libro.setEjemplarList(ejemplarList);

            libroList.add(libro);
        }

    }

    public static void devolverLibro(){
        socioSelcDevolver(filterSocioVIPCom());
    }

    public static void prestarLibro(){
        soscioSelcPrestar(filterSocioVIPCom());

    }

    // Private

    private static void libSelecion(int opSocId, List<ISocio> socioList){
        System.out.println("Seleccione el 'ISNB' de libro a prestar");
        libroList.forEach(libro -> {
            System.out.println("\n" +
                    "Libro\n" +
                    "Codigo ISNB: "+libro.getIBNS() +"\n"+
                    "name: "+libro.getName()+"\n");

        });
        System.out.print("-> ");
        String opcLibro = sc.nextLine();

        socioList.forEach(socio -> {
            if(socio.getId() == opSocId){
                Optional<Libro> libroOptional = libroList.stream().filter(libro -> libro.getIBNS().equalsIgnoreCase(opcLibro)).findAny();

                libroOptional.ifPresent(libro ->  socio.pedirEjemplar(libro.prestar(socio)));


            }
        });
    }


    private static List<ISocio> filterSocioVIPCom(){
        contextMensaje.imprimir(new MsjSocio());
        int opcSc = Integer.parseInt(contextMensaje.respuesta());

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

        contextMensaje.imprimir(new MsjSocioDescripcion(socioList, TyposDescripcion.LIST_DESCRIPCION_SOCIO));

        int opSocId = contextMensaje.respuestaInt();

        socioList.forEach(socio -> {
            if(socio.getId() == opSocId){

                if(socio instanceof SocioVIP) {
                    System.out.println("Seleccione el IBNS del ejemplar a devolver");
                    socio.getEjemplaresRetirados().forEach(ejemplar -> System.out.println(ejemplar.getLibro().getIBNS()));
                    System.out.print("-> ");
                    sc.nextLine();
                    String ibnsSel = sc.nextLine();


                    libroList.forEach(libro -> {
                        if(Objects.equals(libro.getIBNS(), ibnsSel)){
                            Ejemplar ejemplar = socio.devolverEjemplar(ibnsSel);
                            libro.registrar(ejemplar, socio);
                        }
                    });

                }else{
                    assert socio instanceof SocioProxy;
                    SocioProxy socioProxy = (SocioProxy) socio;
                    Ejemplar ejemplar = socioProxy.devolverEjemplar();
                    libroList.forEach(libro -> libro.registrar(ejemplar, socio));
                }

            }
        });

    }

    private static void soscioSelcPrestar(List<ISocio> socioStream){

        contextMensaje.imprimir(new MsjSocioDescripcion(socioStream, TyposDescripcion.LIST_DESCRIPCION_SOCIO));

        int opSocId = contextMensaje.respuestaInt();

        libSelecion(opSocId, socioStream);
    }


    public static List<Libro> getLibroList() {
        return libroList;
    }

    public static void setLibroList(List<Libro> libroList) {
        LibroController.libroList = libroList;
    }
}
