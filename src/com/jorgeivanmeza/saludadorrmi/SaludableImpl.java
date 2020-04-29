package com.jorgeivanmeza.saludadorrmi;

import java.rmi.*;

public class SaludableImpl implements Saludable 
{
    public SaludableImpl()
    {
        super();
    }

    // Métodos no remotos //

    public String saludarDeDia(String nombre) 
    {
        return "Buenos dias " + nombre;
    }

    public String saludarDeTarde(String nombre) 
    {
        return "Buenas tardes " + nombre;
    }

    public String saludarDeNoche(String nombre) 
    {
        return "Buenas noches " + nombre;
    }

    // Métodos remotos (vienen de la interfaz remota) //

    @Override
    public String saludar(int hora, String nombre)
        throws RemoteException
    {
        if (hora >= 6 && hora <= 12)
                return this.saludarDeDia(nombre);

        if (hora > 12 && hora <= 18)
                return this.saludarDeTarde(nombre);

        return this.saludarDeNoche(nombre);
    }
}