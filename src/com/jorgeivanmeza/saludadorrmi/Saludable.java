package com.jorgeivanmeza.saludadorrmi;

import java.rmi.*;

public interface Saludable extends Remote 
{
    String saludar(int hora, String nombre)
            throws RemoteException;
}
