package com.example.biblotecaQuark.Vista.CahinOfRepository;

import com.example.biblotecaQuark.Controlador.LibroController;
import com.example.biblotecaQuark.Modelo.Libro.Libro;

// Opc 1;
public class OpcLibro extends MenuOpciones{
    @Override
    public void opcion(Integer opc) {

        if(opc == 1) {
            int opcLib = 5;
            do {
                System.out.println("************************");
                System.out.println("****** Menu Libro ******");
                System.out.println("*********+**************");
                System.out.println("1 -> Crear libro");
                System.out.println("2 -> Listar libros");
                System.out.println("3 -> Prestar libro");
                System.out.println("4 -> Devolver libro");
                System.out.println("5 -> Volver");
                opcLib = sc.nextInt();

                if (opcLib == 1) {
                    LibroController.dataLibro();
                } else if (opcLib == 2) {
                    System.out.println(LibroController.getLibroList());
                } else if (opcLib == 3) {
                    LibroController.prestarLibro();
                } else if (opcLib == 4) {
                    LibroController.devolverLibro();
                }


            }while (opcLib != 5);

        }else{
            this.menuOpciones.opcion(opc);
        }

    }
}
