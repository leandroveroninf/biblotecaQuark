package com.example.biblotecaQuark.Modelo.Prestamo;

import com.example.biblotecaQuark.Modelo.FactorySocios.ISocio;
import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;

public class PrestamoData {
    private Ejemplar ejemplar;
    private ISocio socio;
    private String fecha;

    private PrestamoTypo prestamoTypo;

    public PrestamoData(Ejemplar ejemplar, ISocio socio, String fecha) {
        this.ejemplar = ejemplar;
        this.socio = socio;
        this.fecha = fecha;
    }




    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public ISocio getSocio() {
        return socio;
    }

    public void setSocio(ISocio socio) {
        this.socio = socio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public PrestamoTypo getPrestamoTypo() {
        return prestamoTypo;
    }

    public void setPrestamoTypo(PrestamoTypo prestamoTypo) {
        System.out.println("typo prestado:  "+prestamoTypo);
        this.prestamoTypo = prestamoTypo;
    }

    @Override
    public String toString() {


        return "=============================\n" +
                "Fecha: "+fecha+"\n" +
                "Tipo: "+ prestamoTypo+ "\n" +
                "Id Socio: "+ socio.getId() +"\n"+
                "Socio -> "+socio.getName()+" "+socio.getLasName()+"\n" +
                "Ejemplar ->  Numero de edicion: "+ ejemplar.getNumEdition() + ", Ubicacion:  "+ejemplar.getUbicacion()+ "\n" +
                "Del libro: "+ejemplar.getLibro().getName()+ ", INBS: "+ ejemplar.getLibro().getIBNS()+"\n" +
                "=============================\n";
    }
}
