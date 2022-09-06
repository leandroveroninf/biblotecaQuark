package com.example.biblotecaQuark.Presentador.Decorador;

import java.util.Scanner;

public class ValidaIsString extends ValidaDecorador{

    private String val;
    private Scanner sc = new Scanner(System.in);

    public ValidaIsString(IValida valida) {
        super(valida);
    }

    @Override
    public boolean dateString(String value) {
        if(super.dateString(value)){
            return this.isString(super.resultString());

        }
        return  false;
    }

    @Override
    public boolean dateInt(String value) {
        return super.dateInt(value);
    }

    @Override
    public int resultInt() {
        return super.resultInt();
    }

    @Override
    public String resultString() {
        return val;
    }



    private boolean isString(String date){
        try{

            Integer val = Integer.parseInt(date);
            System.out.println("El valor no tiene que ser un numero");
            System.out.print("-> ");
            this.isString(sc.nextLine());
            return false;
        }catch(Exception e){
            val = date;
            return true;
        }
    }

}
