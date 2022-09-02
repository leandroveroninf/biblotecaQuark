package com.example.biblotecaQuark.Controlador;

import com.example.biblotecaQuark.Modelo.FactorySocios.ISocio;
import com.example.biblotecaQuark.Modelo.FactorySocios.SocioProxy;
import com.example.biblotecaQuark.Modelo.FactorySocios.SocioVIP;
import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;
import com.example.biblotecaQuark.Modelo.Libro.Libro;

import java.util.*;
import java.util.stream.Stream;

public class LibroController {
    private static List<Libro> libroList;
    private static Scanner sc = new Scanner(System.in);

    public static void dataLibro(){
        libroList = new ArrayList<>();
        System.out.println("Cantidad de libros");
        int cantLicbos = 1;
        cantLicbos = sc.nextInt();

        for(int n = 0; n < cantLicbos; n++) {
            System.out.println("Libro ----");
            sc.nextLine();
            System.out.println("-> name");
            String nombre = sc.nextLine();
            System.out.println("-> autor");
            String autor = sc.nextLine();
            System.out.println("-> IBNS");
            String ibns = sc.nextLine();
            System.out.println("Cantidad de ejemlates");
            Integer cantEjm = sc.nextInt();

            Libro libro = new Libro(nombre, autor);
            boolean atISBN = libro.crearISBN(ibns);
            while(!atISBN){
                System.out.println("-> IBNS");
                sc.nextLine();
                ibns = sc.nextLine();
                atISBN = libro.crearISBN(ibns);
            }

            libro.setCantEjemplar(cantEjm);


            List<Ejemplar> ejemplarList = new ArrayList<>();

            for (int i = 0; i < libro.getCantEjemplar(); i++) {
                ejemplarList.add(new Ejemplar(libro, (i+1)));

            }

            libro.setEjemplarList(ejemplarList);

            libroList.add(libro);
        }

    }

    public static void devolverLibro(){
        System.out.println("Seleccionar socio que devolvera el libro");
        System.out.println("1 -> Socio comun");
        System.out.println("2 -> Socio VIP");
        int opcSc = sc.nextInt();
        System.out.println("Seleccione un id");
        List<ISocio> socioList = SocioController.getSocioList();
        if(opcSc == 1){

            List<ISocio> sociComun = socioList.stream().filter(socio -> socio instanceof SocioProxy).toList();

            System.out.println("Socios comunes");
            socioSelcDevolver(sociComun, libroList);

        }else{
            List<ISocio> socioVIO = socioList.stream().filter(socioVIP -> socioVIP instanceof SocioVIP).toList();
            System.out.println("Socio VIP");
            socioSelcDevolver(socioVIO, libroList);
        }
    }

    public static void libSelecion(int opSocId, List<ISocio> socioList){
        System.out.println("Seleccione el libro a prestar");
        libroList.forEach(libro -> {
            System.out.println("libri ->"+libro.getIBNS());

        });
        sc.nextLine();
        String opcLibro = sc.nextLine();

        socioList.forEach(socio -> {
            if(socio.getId() == opSocId){
                Optional<Libro> libroOptional = libroList.stream().filter(libro -> libro.getIBNS().equalsIgnoreCase(opcLibro)).findAny();
                System.out.println("libroOptional "+libroOptional);
                libroOptional.ifPresent(libro -> socio.pedirEjemplar(libro.prestar(socio)));


            }
        });
    }

    public static void prestarLibro(){
        System.out.println("Seleccionar socio para presar");
        System.out.println("1 -> Socio comun");
        System.out.println("2 -> Socio VIP");
        int opcSc = sc.nextInt();

        List<ISocio> socioList = SocioController.getSocioList();

        if(opcSc == 1){

            List<ISocio> sociComun = socioList.stream().filter(socio -> socio instanceof SocioProxy).toList();

            System.out.println("Socios comunes");
            soscioSelcPrestar(sociComun);

        }else{
            List<ISocio> socioVIO = socioList.stream().filter(socioVIP -> socioVIP instanceof SocioVIP).toList();
            System.out.println("Socio VIP");
            soscioSelcPrestar(socioVIO);
        }

    }

    // Private
    private static void socioSelcDevolver(List<ISocio> socioList, List<Libro> libroList){
        socioList.forEach(socio -> {
            System.out.println("id -> "+ socio.getId());
            System.out.println("Full name -> "+socio.getName()+", "+socio.getLasName());
        });

        int opSocId = sc.nextInt();

        socioList.forEach(socio -> {
            if(socio.getId() == opSocId){

                if(socio instanceof SocioVIP) {
                    System.out.println("Seleccione el IBNS del ejemplar a devolver");
                    socio.getEjemplaresRetirados().forEach(ejemplar -> System.out.println(ejemplar.getLibro().getIBNS()));
                    sc.nextLine();
                    String ibnsSel = sc.nextLine();


                    libroList.forEach(libro -> {
                        if(Objects.equals(libro.getIBNS(), ibnsSel)){
                            libro.registrar(socio.devolverEjemplar(ibnsSel), socio);
                        }
                    });

                }else{
                    SocioProxy socioProxy = new SocioProxy(socio);
                    libroList.forEach(libro -> libro.registrar(socioProxy.devolverEjemplar(), socio));
                }

            }
        });

    }

    private static void soscioSelcPrestar(List<ISocio> socioStream){
        socioStream.forEach(socio -> {
            System.out.println("id -> "+ socio.getId());
            System.out.println("Full name -> "+socio.getName()+", "+socio.getLasName());
        });

        int opSocId = sc.nextInt();

        libSelecion(opSocId, socioStream);
    }



    public static List<Libro> getLibroList() {
        return libroList;
    }

    public static void setLibroList(List<Libro> libroList) {
        LibroController.libroList = libroList;
    }
}
