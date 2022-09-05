package com.example.biblotecaQuark.Presentador.Decorador;

public interface IValida {

    boolean dateString(String value);
    boolean dateInt(String value);

    int resultInt();
    String resultString();

}
