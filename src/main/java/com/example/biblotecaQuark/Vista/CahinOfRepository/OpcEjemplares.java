package com.example.biblotecaQuark.Vista.CahinOfRepository;

import com.example.biblotecaQuark.Controlador.EjemplarController;

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
                opcSel = sc.nextInt();
                if (opcSel == 1) {
                    EjemplarController.addEjempalar();
                } else if (opcSel == 2) {
                    System.out.println(EjemplarController.listEjemplar());
                }
            }while (opcSel != 3);
        }
    }
}
