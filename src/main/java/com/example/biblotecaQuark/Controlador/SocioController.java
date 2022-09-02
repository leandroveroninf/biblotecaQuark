package com.example.biblotecaQuark.Controlador;

import com.example.biblotecaQuark.Modelo.FactorySocios.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SocioController {

    private static List<ISocio> socioList;
    private static Scanner sc = new Scanner(System.in);

    public static void dataSocio(){
        socioList = new ArrayList<>();
        System.out.println("********SOCIO*********");
        System.out.println("Cantidad de socio");
        int cant = sc.nextInt();
        ICreatorSocio creatorSocio;

        for (int i = 0; i < cant; i++){
            System.out.println("1 -> Socio comun");
            System.out.println("2 -> Socio VIP");
            int opc = sc.nextInt();
            if(opc == 1){
                creatorSocio = new CreateSocio();
            }else{
                creatorSocio = new CreateSocioVIP();
            }
            sc.nextLine();
            System.out.println("nombre");
            String nombre = sc.nextLine();
            System.out.println("apellido");
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
