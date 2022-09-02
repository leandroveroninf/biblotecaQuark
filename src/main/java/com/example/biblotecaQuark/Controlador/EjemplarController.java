package com.example.biblotecaQuark.Controlador;

import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;
import com.example.biblotecaQuark.Modelo.Libro.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EjemplarController {
    private static Scanner sc = new Scanner(System.in);
    public static void addEjempalar(){

        List<Libro> libroList = LibroController.getLibroList();

        System.out.println("Seleccione el IBNS que quieres crear su ejemplar");
        libroList.forEach(libro -> System.out.println(libro.getIBNS()));
        String ibns = sc.nextLine();

        Libro libroSel = libroList.stream().filter(libro -> Objects.equals(libro.getIBNS(), ibns)).toList().get(0);

        if(libroSel != null){

            System.out.println("Ingrese la cantidad de ejemplares que quieres agregar");
            int cant = sc.nextInt();

            List<Ejemplar> ejemplarList = libroSel.getEjemplarList();
            int ulNumEd = 0;
            if(!ejemplarList.isEmpty()){
                ulNumEd = ejemplarList.get(libroSel.getEjemplarList().size()-1).getNumEdition();
            }


            for (int i = 0; i < cant; i++){
                ejemplarList.add(new Ejemplar(libroSel, ++ulNumEd));
            }

            libroSel.setEjemplarList(ejemplarList);

        }else{
            System.out.println("libro no encontrado");
        }
    }
    public static List<Ejemplar> listEjemplar(){
        List<Ejemplar> ejemplarList = new ArrayList<>();


        LibroController.getLibroList().forEach(libro -> {
            ejemplarList.addAll(libro.getEjemplarList());
        });

        return ejemplarList;


    }

}
