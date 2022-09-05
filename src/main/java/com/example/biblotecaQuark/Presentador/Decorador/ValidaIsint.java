package com.example.biblotecaQuark.Presentador.Decorador;

import java.util.Scanner;

public class ValidaIsint extends ValidaDecorador{

    private int val;
    private Scanner sc = new Scanner(System.in);


    public ValidaIsint(IValida valida) {
        super(valida);
    }



    @Override
    public boolean dateString(String value) {
        return  super.dateString(value);
    }

    @Override
    public boolean dateInt(String value) {
        return super.dateInt(value) && isNumber(value);
    }

    @Override
    public int resultInt() {
        return val;
    }

    @Override
    public String resultString() {
        return super.resultString();
    }



    private boolean isNumber(String date){
        try{

            val = Integer.parseInt(date);

            return true;
        }catch(Exception e){
            System.out.println("El valor tiene que ser un numero");
            System.out.print("-> ");
            this.isNumber(sc.nextLine());
            return false;
        }
    }


}
