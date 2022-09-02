package com.example.biblotecaQuark.Vista;

import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);

    private static Integer opc = 0;

    public static Integer menuPrincipal(){
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

    public static int menuSocio(){
        System.out.println("************************");
        System.out.println("****** Menu socio ******");
        System.out.println("*********+**************");
        System.out.println("2 -> Crear Socio");
        System.out.println("3 -> Listar Socios");
        System.out.println("4 -> Listar Socios VIP");
        return opc;
    }

    public static int menuLibro(){
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
