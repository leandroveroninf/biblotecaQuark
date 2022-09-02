package com.example.biblotecaQuark.Modelo.FactorySocios;

public class CreateSocioVIP implements ICreatorSocio{
    private static Integer idSocioVIP = 1;

    @Override
    public ISocio createSocio(String name, String lasName) {
        System.out.println(idSocioVIP);
        return new SocioVIP(name, lasName, idSocioVIP++);
    }
}
