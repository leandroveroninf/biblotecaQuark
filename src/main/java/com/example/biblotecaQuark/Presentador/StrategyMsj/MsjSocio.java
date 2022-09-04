package com.example.biblotecaQuark.Presentador.StrategyMsj;

import java.util.Scanner;

public class MsjSocio extends AbstractMensaje {

    public MsjSocio(){

    }

    public MsjSocio(TyposDescripcion typosDescripcion){
        this.typosDescripcion = typosDescripcion;
    }

    @Override
    public void imprimirMensaje() {
        System.out.println("Seleccionar Socio");
        System.out.println("1 -> Socio comun");
        System.out.println("2 -> Socio VIP");
        System.out.print("-> ");
        result = sc.nextLine();
    }

    @Override
    public String respuestaString() {
        return result;
    }


}
