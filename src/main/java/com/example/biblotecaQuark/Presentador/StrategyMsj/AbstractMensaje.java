package com.example.biblotecaQuark.Presentador.StrategyMsj;

import java.util.Scanner;

public abstract class AbstractMensaje {

        protected Scanner sc = new Scanner(System.in);
        protected String result = "";
        protected int resultInt;

        protected TyposDescripcion typosDescripcion;
        abstract void imprimirMensaje();
        abstract String respuestaString();

        abstract Integer respuestaInt();
}
