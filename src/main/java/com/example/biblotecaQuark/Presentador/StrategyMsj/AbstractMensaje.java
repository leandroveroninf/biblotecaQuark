package com.example.biblotecaQuark.Presentador.StrategyMsj;

import java.util.Scanner;

public abstract class AbstractMensaje {

        protected Scanner sc = new Scanner(System.in);
        protected String result = "";
        protected int resultInt;

        protected TyposDescripcion typosDescripcion;
        abstract void imprimirMensaje();
        abstract String respuestaString();

        public Integer respuestaInt() {
                try{
                        resultInt = Integer.parseInt(result);
                        return resultInt;
                }catch (Exception e){
                        System.out.println("Deves ingresar un numero");
                        imprimirMensaje();
                }
                return null;
        }
}
