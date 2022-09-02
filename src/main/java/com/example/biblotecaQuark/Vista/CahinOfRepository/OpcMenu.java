package com.example.biblotecaQuark.Vista.CahinOfRepository;

public class OpcMenu extends MenuOpciones{
    @Override
    public void opcion(Integer opc) {
        if(opc > 2) {
            System.out.println("******************");
            System.out.println("****** Menu ******");
            System.out.println("*********+********");
        }
    }
}
