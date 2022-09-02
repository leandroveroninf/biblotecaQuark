package com.example.biblotecaQuark.Vista;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);

    private int opc = 0;

    public Menu(){

    }
    public Integer menuPrincipal(){
        System.out.println("******************");
        System.out.println("****** Menu ******");
        System.out.println("*********+********");
        System.out.println("1 -> Libro");
        System.out.println("2 -> Socio");
        System.out.println("3 -> Libros Creados");
        System.out.println("4 -> Socios creados");
        System.out.println("5 -> Ver prestamos");
        return sc.nextInt();
    }

    public int menuSocio(){
        System.out.println("************************");
        System.out.println("****** Menu socio ******");
        System.out.println("*********+**************");
        System.out.println("2 -> Crear Socio");
        System.out.println("3 -> Listar Socios");
        System.out.println("4 -> Listar Socios VIP");
        return opc;
    }

    public int menuLibro(){
        System.out.println("************************");
        System.out.println("****** Menu Libro ******");
        System.out.println("*********+**************");
        System.out.println("1 -> Crear libro");
        System.out.println("2 -> Crear Socio");
        System.out.println("3 -> Libros Creados");
        System.out.println("4 -> Socios creados");
        return opc;
    }


}
