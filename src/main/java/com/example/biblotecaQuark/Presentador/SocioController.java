package com.example.biblotecaQuark.Presentador;

import com.example.biblotecaQuark.Modelo.FactorySocios.*;
import com.example.biblotecaQuark.Presentador.StrategyMsj.ContextMensaje;
import com.example.biblotecaQuark.Presentador.StrategyMsj.MsjSocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SocioController {

    private static List<ISocio> socioList;
    private static Scanner sc = new Scanner(System.in);
    private static ContextMensaje contextMensaje = new ContextMensaje();


    public static void dataSocio(){
        socioList = new ArrayList<>();
        System.out.println("********SOCIO*********");
        System.out.println("Cantidad de socio");
        System.out.print("-> ");
        int cant = sc.nextInt();
        ICreatorSocio creatorSocio;

        for (int i = 0; i < cant; i++){
            contextMensaje.imprimir(new MsjSocio());
            int opc = contextMensaje.respuestaInt();

            if(opc == 1){
                creatorSocio = new CreateSocio();
            }else{
                creatorSocio = new CreateSocioVIP();
            }
            System.out.print("Name: ");
            String nombre = sc.nextLine();
            System.out.print("LasName: ");
            String apellido = sc.nextLine();

            socioList.add(creatorSocio.createSocio(nombre, apellido));

        }
    }
    public static List<ISocio> getSocioList() {
        return socioList;
    }

    public static void setSocioList(List<ISocio> socioList) {
        SocioController.socioList = socioList;
    }
}
