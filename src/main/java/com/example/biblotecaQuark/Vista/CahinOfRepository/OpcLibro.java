package com.example.biblotecaQuark.Vista.CahinOfRepository;

import com.example.biblotecaQuark.Modelo.Prestamo.Prestamo;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsNotNull;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsint;
import com.example.biblotecaQuark.Presentador.LibroController;

// Opc 1;
public class OpcLibro extends MenuOpciones{
    @Override
    public void opcion(Integer opc) {

        if(opc == 1) {
            int opcLib = 6;
            do {
                System.out.println("************************");
                System.out.println("****** Menu Libro ******");
                System.out.println("*********+**************");
                System.out.println("1 -> Crear libro");
                System.out.println("2 -> Listar libros");
                System.out.println("3 -> Prestar libro");
                System.out.println("4 -> Devolver libro");
                System.out.println("5 -> Historial de pedidos");
                System.out.println("6 -> Volver");
                System.out.print("-> ");
                validaDecorador = new ValidaIsint(new ValidaIsNotNull());
                validaDecorador.dateInt(sc.nextLine());
                opcLib = validaDecorador.resultInt();

                if (opcLib == 1) {
                    LibroController.dataLibro();
                } else if (opcLib == 2) {
                    LibroController.findAllLibros();
                } else if (opcLib == 3) {
                    LibroController.prestarLibro();
                } else if (opcLib == 4) {
                    LibroController.devolverLibro();
                }else if (opcLib == 5) {
                    if(Prestamo.ObtenerPrestamos() != null) {
                        Prestamo.ObtenerPrestamos().forEach(prestamoData -> System.out.println(prestamoData.toString()));
                    }else{
                        System.out.println("No hay Historial de pedidos");
                    }
                }


            }while (opcLib != 6);

        }else{
            this.menuOpciones.opcion(opc);
        }

    }
}
