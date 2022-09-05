package com.example.biblotecaQuark.Presentador.Decorador;

public class ValidaDecorador implements IValida{

    private IValida valida;

    public ValidaDecorador(IValida valida){
        this.valida = valida;
    }

    @Override
    public boolean dateString(String value) {
        return this.valida.dateString(value);
    }

    @Override
    public boolean dateInt(String value) {
        return this.valida.dateInt(value);
    }

    @Override
    public int resultInt() {
        return this.valida.resultInt();
    }

    @Override
    public String resultString() {
        return this.valida.resultString();
    }
}
