package com.example.biblotecaQuark.Vista.CahinOfRepository;

import com.example.biblotecaQuark.Presentador.Decorador.ValidaDecorador;

import java.util.Scanner;

public abstract class MenuOpciones {

    protected MenuOpciones menuOpciones;
    protected Scanner sc = new Scanner(System.in);
    protected ValidaDecorador validaDecorador;


    public void agregarSigOpc(MenuOpciones menuOpciones){
        this.menuOpciones = menuOpciones;
    }

    public abstract void opcion(Integer opc);


}
