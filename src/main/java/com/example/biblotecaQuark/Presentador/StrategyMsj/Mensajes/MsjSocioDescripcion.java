package com.example.biblotecaQuark.Presentador.StrategyMsj.Mensajes;

import com.example.biblotecaQuark.Modelo.FactorySocios.ISocio;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaDecorador;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsNotNull;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsString;
import com.example.biblotecaQuark.Presentador.Decorador.ValidaIsint;
import com.example.biblotecaQuark.Presentador.StrategyMsj.MsjSocio;
import com.example.biblotecaQuark.Presentador.StrategyMsj.TyposDescripcion;

import java.util.List;

public class MsjSocioDescripcion extends MsjSocio {

    private List<ISocio> socioList;
    private ISocio socio;
    private TyposDescripcion typosDescripcion;
    private ValidaDecorador validaDecorador;


    public MsjSocioDescripcion(List<ISocio> socioList, TyposDescripcion typosDescripcion){
        this.socioList = socioList;
        this.typosDescripcion = typosDescripcion;
    }

    public MsjSocioDescripcion(ISocio socio, TyposDescripcion typosDescripcion){
        this.socio = socio;
        this.typosDescripcion = typosDescripcion;
    }
    @Override
    public void imprimirMensaje() {

        if(typosDescripcion == TyposDescripcion.LIST_DESCRIPCION_SOCIO){
            this.result = imprimirDescripcionSocio();
            this.respuestaInt();
        }

        if(typosDescripcion == TyposDescripcion.LIST_ISNB_SOCIO_DEVOLVER){
            this.result = imprimeISBN_Socios();
        }

    }

    @Override
    public String respuestaString() {
        return result;
    }


    private String imprimirDescripcionSocio(){
        validaDecorador = new ValidaIsint( new ValidaIsNotNull());

        socioList.forEach(socio -> {
            System.out.println("\n" +
                        "ID: " + socio.getId() + "\n" +
                        "Name: " + socio.getName() + "\n" +
                        "LasName: " + socio.getLasName() + "\n" +
                        "Cantidad de ejemplares retirados: " + socio.getEjemplaresRetirados().size() + "\n" +
                        "Cantidad que puede retirar: " + socio.getCantRetirar() + "\n");
            });
        System.out.print("-> ");
        validaDecorador.dateInt(sc.nextLine());

        String res = String.valueOf(validaDecorador.resultInt());

        return res;
    }


    private String imprimeISBN_Socios(){
        validaDecorador = new ValidaIsString( new ValidaIsNotNull());

        System.out.println("Seleccione el IBNS del ejemplar a devolver");
        socio.getEjemplaresRetirados().forEach(ejemplar -> System.out.println(ejemplar.getLibro().getIBNS()));
        System.out.print("-> ");
        validaDecorador.dateInt(sc.nextLine());


        return validaDecorador.resultString();


    }


}
