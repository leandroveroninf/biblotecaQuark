package com.example.biblotecaQuark.Modelo.Prestamo;

import com.example.biblotecaQuark.Modelo.FactorySocios.ISocio;
import com.example.biblotecaQuark.Modelo.FactorySocios.Socio;
import com.example.biblotecaQuark.Modelo.Interfaces.IPrestamo;
import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;
import com.example.biblotecaQuark.Modelo.Singleton.PrestamosObtenidos;

import java.util.List;


public class Prestamo {

    private String fecha;
    private Ejemplar ejemplar;
    private ISocio iSocio;
    private static PrestamosObtenidos prestamosObtenidos;
    private PrestamoData prestamoData;



    public Prestamo(Ejemplar ejemplar, ISocio iSocio) {
        this.ejemplar = ejemplar;
        this.iSocio = iSocio;
        this.fecha = "3/9/2022";
        prestamoData = new PrestamoData(this.ejemplar, this.iSocio, this.fecha);
    }


    public static List<PrestamoData> ObtenerPrestamos() {
        return prestamosObtenidos.ObtenerPrestamos();
    }

    public void tipoOperacion(PrestamoTypo prestamoTypo){

        prestamoData.setPrestamoTypo(prestamoTypo);
        prestamosObtenidos = PrestamosObtenidos.getInstance(prestamoData);
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public ISocio getiSocio() {
        return iSocio;
    }

    public void setiSocio(ISocio iSocio) {
        this.iSocio = iSocio;
    }


    @Override
    public String toString() {
        return "Prestamo{" +
                "fecha='" + fecha + '\'' +
                ", ejemplar=" + ejemplar +
                ", iSocio=" + iSocio +
                ", prestamosObtenidos=" + prestamosObtenidos +
                ", prestamoData=" + prestamoData +
                '}';
    }
}
