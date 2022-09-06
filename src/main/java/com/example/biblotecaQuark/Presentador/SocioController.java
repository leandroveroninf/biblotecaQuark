package com.example.biblotecaQuark.Presentador;

import com.example.biblotecaQuark.Modelo.FactorySocios.*;
import com.example.biblotecaQuark.Presentador.Decorador.*;
import com.example.biblotecaQuark.Presentador.StrategyMsj.ContextMensaje;
import com.example.biblotecaQuark.Presentador.StrategyMsj.MsjSocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SocioController {

    private static List<ISocio> socioList = new ArrayList<ISocio>();
    private static Scanner sc = new Scanner(System.in);
    private static ContextMensaje contextMensaje = new ContextMensaje();
    private static ValidaDecorador validaDecorador;

    public static void dataSocio(){

        ICreatorSocio creatorSocio;
        int cant = cantSocios();

        for (int i = 0; i < cant; i++){
            contextMensaje.imprimir(new MsjSocio());

            if(contextMensaje.respuestaInt() == 1){
                creatorSocio = new CreateSocio();
            }else{
                creatorSocio = new CreateSocioVIP();
            }

            crearSocio(creatorSocio);

        }
    }
    public static List<ISocio> getSocioList() {
        return socioList;
    }

    public static void setSocioList(List<ISocio> socioList) {
        SocioController.socioList = socioList;
    }



    // METODOS PRIVADOS
    private static Integer cantSocios(){

        validaDecorador = new ValidaIsint(new ValidaIsNotNull());
        int cant;

        System.out.println("********SOCIO*********");
        System.out.println("Cantidad de socio");
        System.out.print("-> ");

        validaDecorador.dateInt(sc.nextLine());
        cant = validaDecorador.resultInt();

        return cant;
    }



    private static void crearSocio(ICreatorSocio creatorSocio){

        String nombre;
        String apellido;

        validaDecorador = new ValidaIsString( new ValidaIsNotNull());
        System.out.print("-> Name: ");
        validaDecorador.dateString(sc.nextLine());
        nombre = validaDecorador.resultString();

        System.out.print("-> LasName: ");
        validaDecorador.dateString(sc.nextLine());
        apellido = validaDecorador.resultString();


        if(creatorSocio instanceof CreateSocioVIP){
            validaDecorador = new ValidaIsint( new ValidaIsNotNull());
            System.out.print("-> Cuota: ");
            validaDecorador.dateInt(sc.nextLine());
            int cuota = validaDecorador.resultInt();

            SocioVIP socioVIP = (SocioVIP) creatorSocio.createSocio(nombre, apellido);
            socioVIP.setCuetaMensual(cuota);
            socioList.add(socioVIP);
        }else {
            socioList.add(creatorSocio.createSocio(nombre, apellido));
        }
    }




}
