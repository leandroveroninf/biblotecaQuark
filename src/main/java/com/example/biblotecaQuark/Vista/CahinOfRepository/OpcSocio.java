package com.example.biblotecaQuark.Vista.CahinOfRepository;

import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsNotNull;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsint;
import com.example.biblotecaQuark.Presentador.LibroController;
import com.example.biblotecaQuark.Presentador.SocioController;

public class OpcSocio extends MenuOpciones{
    @Override
    public void opcion(Integer opc) {
        if(opc == 2) {

            int opcSel = 5;
            do {
                System.out.println("********************");
                System.out.println("****** Socios ******");
                System.out.println("*********+**********");
                System.out.println("1 -> Agregar Socio");
                System.out.println("2 -> Listar socios");
                System.out.println("3 -> Pedir libro");
                System.out.println("4 -> Devolver libro");
                System.out.println("5 -> Volver");
                System.out.print("-> ");
                validaDecorador = new ValidaIsint(new ValidaIsNotNull());
                validaDecorador.dateInt(sc.nextLine());
                opcSel = validaDecorador.resultInt();

                if (opcSel == 1) {
                    SocioController.dataSocio();
                } else if (opcSel == 2) {
                    System.out.println(SocioController.getSocioList());
                }else if (opcSel == 3) {
                    LibroController.prestarLibro();
                }else if (opcSel == 4) {
                    LibroController.devolverLibro();
                }

            }while(opcSel != 5);

        }else{
            this.menuOpciones.opcion(opc);
        }
    }
}
