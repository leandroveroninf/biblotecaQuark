package com.example.biblotecaQuark.Vista.CahinOfRepository;

import com.example.biblotecaQuark.Controlador.SocioController;

public class OpcSocio extends MenuOpciones{
    @Override
    public void opcion(Integer opc) {
        if(opc == 2) {
            System.out.println("********************");
            System.out.println("****** Socios ******");
            System.out.println("*********+**********");
            System.out.println("1 -> Agregar Socio");
            System.out.println("2 -> Listar socios");
            System.out.println("3 -> Volver");
            int opcSel = sc.nextInt();

            if(opcSel == 1){
                SocioController.dataSocio();
            }else if(opcSel == 2){
                System.out.println(SocioController.getSocioList());
            }else{

            }


        }else{
            this.opcion(opc);
        }
    }
}
