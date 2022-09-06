package com.example.biblotecaQuark.Vista.CahinOfRepository;

import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsNotNull;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsint;
import com.example.biblotecaQuark.Presentador.EjemplarController;

public class OpcEjemplares extends MenuOpciones{
    @Override
    public void opcion(Integer opc) {
        if(opc == 3) {
            int opcSel = 3;
            do {
                System.out.println("************************");
                System.out.println("****** Ejemplares ******");
                System.out.println("*********+**************");
                System.out.println("1 -> Agregar ejemplar");
                System.out.println("2 -> Listar ejemplares");
                System.out.println("3 -> Volver");
                System.out.print("-> ");
                validaDecorador = new ValidaIsint(new ValidaIsNotNull());
                validaDecorador.dateInt(sc.nextLine());
                opcSel = validaDecorador.resultInt();
                if (opcSel == 1) {
                    EjemplarController.addEjempalar();
                } else if (opcSel == 2) {
                    EjemplarController.mostrarEjemplaresDelLibro();
                }
            }while (opcSel != 3);
        }
    }
}
