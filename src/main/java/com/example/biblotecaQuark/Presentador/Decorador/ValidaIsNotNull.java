package com.example.biblotecaQuark.Presentador.Decorador;

public class ValidaIsNotNull implements IValida{
    private String val;
    private Integer valint;


    @Override
    public boolean dateString(String value) {

        if(value == null || value.equalsIgnoreCase("")){
            System.out.println("Tienes que ingresar un valor");
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
