package com.example.biblotecaQuark.Presentador;

import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;
import com.example.biblotecaQuark.Modelo.Libro.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EjemplarController {
    private static Scanner sc = new Scanner(System.in);
    private static List<Libro> libroList = LibroController.getLibroList();
    public static void addEjempalar(){

        System.out.println("Seleccione el IBNS que quieres crear su ejemplar");
        libroList.forEach(libro -> {
            System.out.println("********************************\n" +
                    "-> Libro \n" +
                    "\t\t Name: " + libro.getName()+"\n"+
                    "\t\t Codigo INBS: "+ libro.getIBNS() +"\n"+
                    "\t\t Cant ejemplares: "+libro.getCantEjemplar()+"\n" +
                    "********************************\n");
        });
        String ibns = sc.nextLine();

        if(ibns.isEmpty()){
            ibns = sc.nextLine();
        }

        String finalIbns = ibns;
        Libro libroSel = libroList.stream().filter(libro -> Objects.equals(libro.getIBNS(), finalIbns)).toList().get(0);

        if(libroSel != null){

            System.out.println("Ingrese la cantidad de ejemplares que quieres agregar");
            int cant = sc.nextInt();

            List<Ejemplar> ejemplarList = libroSel.getEjemplarList();
            int ulNumEd = 0;
            if(!ejemplarList.isEmpty()){
                ulNumEd = ejemplarList.get(libroSel.getEjemplarList().size()-1).getNumEdition();
            }

            System.out.println("Ubicacion de los ejemplares");
            String ubicacion = sc.nextLine();
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
