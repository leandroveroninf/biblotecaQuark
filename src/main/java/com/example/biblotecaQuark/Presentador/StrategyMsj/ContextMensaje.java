package com.example.biblotecaQuark.Presentador.StrategyMsj;

public class ContextMensaje {

    private AbstractMensaje mensaje;

    public void imprimir(AbstractMensaje mensaje){
        this.mensaje = mensaje;
        mensaje.imprimirMensaje();
    }

    public String respuesta(){
        return this.mensaje.respuestaString();
    }

    public Integer respuestaInt(){
        return this.mensaje.respuestaInt();
    }

}
