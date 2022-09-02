package com.example.biblotecaQuark.Controlador;

import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;
import com.example.biblotecaQuark.Modelo.Libro.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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


    public static List<Libro> getLibroList() {
        return libroList;
    }

    public static void setLibroList(List<Libro> libroList) {
        LibroController.libroList = libroList;
    }
}
