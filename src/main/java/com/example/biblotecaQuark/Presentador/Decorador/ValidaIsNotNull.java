package com.example.biblotecaQuark.Presentador.Decorador;

import java.util.Scanner;

public class ValidaIsNotNull implements IValida{
    private String val;
    private Integer valint;

    private Scanner sc = new Scanner(System.in);

    @Override
    public boolean dateString(String value) {

        if(value == null || value.equalsIgnoreCase("")){
            System.out.println("Tienes que ingresar un valor");
            System.out.print("-> ");
            this.dateString(sc.nextLine());

            return false;
        }

        val = value;
        return true;
    }

    @Override
    public boolean dateInt(String value) {
        return this.dateString(value);
    }

    @Override
    public int resultInt() {
        return this.valint;
    }

    @Override
    public String resultString() {
        return this.val;
    }
}
