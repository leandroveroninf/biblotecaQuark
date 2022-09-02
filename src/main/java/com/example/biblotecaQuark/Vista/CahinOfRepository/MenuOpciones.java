package com.example.biblotecaQuark.Vista.CahinOfRepository;

import java.util.Scanner;

public abstract class MenuOpciones {

    protected MenuOpciones menuOpciones;
    protected Scanner sc = new Scanner(System.in);


    public void agregarSigOpc(MenuOpciones menuOpciones){
        this.menuOpciones = menuOpciones;
    }

    public abstract void opcion(Integer opc);


}
