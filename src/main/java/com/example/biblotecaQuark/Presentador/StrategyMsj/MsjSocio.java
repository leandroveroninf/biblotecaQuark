package com.example.biblotecaQuark.Presentador.StrategyMsj;

import com.example.biblotecaQuark.Modelo.FactorySocios.ISocio;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaDecorador;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsNotNull;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsint;

import java.util.List;
import java.util.Scanner;

public class MsjSocio extends AbstractMensaje {

    private List<ISocio> socioList;
    private ValidaDecorador validaDecorador;


    public MsjSocio(){

    }


    @Override
    public void imprimirMensaje() {
        validaDecorador = new ValidaIsint(new ValidaIsNotNull());
        System.out.println("Seleccionar Socio");
        System.out.println("1 -> Socio comun");
        System.out.println("2 -> Socio VIP");
        System.out.print("-> ");
        validaDecorador.dateInt(sc.nextLine());
        this.resultInt = validaDecorador.resultInt();
    }

    @Override
    public String respuestaString() {
        return result;
    }


    @Override
    public Integer respuestaInt(){
        return this.resultInt;
    }


}
