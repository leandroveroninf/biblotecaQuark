package com.example.biblotecaQuark.Presentador.StrategyMsj;

import com.example.biblotecaQuark.Modelo.FactorySocios.ISocio;

import java.util.List;

public class MsjSocioDescripcion extends MsjSocio{

    private List<ISocio> socioList;
    private TyposDescripcion typosDescripcion;

    public MsjSocioDescripcion(List<ISocio> socioList, TyposDescripcion typosDescripcion){
        this.socioList = socioList;
        this.typosDescripcion = typosDescripcion;
    }

    @Override
    public void imprimirMensaje() {

        if(typosDescripcion == TyposDescripcion.LIST_DESCRIPCION_SOCIO){
            this.result = imprimirDescripcionSocio();
            this.respuestaInt();
        }


    }

    @Override
    public String respuestaString() {
        return result;
    }


    private String imprimirDescripcionSocio(){
        socioList.forEach(socio -> {
            System.out.println("\n" +
                    "ID: "+socio.getId()+"\n" +
                    "Name: "+socio.getName()+"\n" +
                    "LasName: "+socio.getLasName()+"\n" +
                    "Cantidad de ejemplares retirados: "+socio.getEjemplaresRetirados().size()+"\n" +
                    "Cantidad que puede retirar: "+socio.getCantRetirar()+"\n");
        });
        System.out.print("-> ");
        return sc.nextLine();
    }


    private void imprimeISBN_Socios(){
        //socioList.getEjemplaresRetirados().forEach(ejemplar -> System.out.println(ejemplar.getLibro().getIBNS()));
    }


}
