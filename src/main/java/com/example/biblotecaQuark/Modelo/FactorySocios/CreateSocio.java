package com.example.biblotecaQuark.Modelo.FactorySocios;

public class CreateSocio implements ICreatorSocio{
    private static Integer idSocio = 0;
    @Override
    public ISocio createSocio(String name, String lasName) {
        return new SocioProxy(new Socio(name, lasName, ++idSocio));
    }
}
