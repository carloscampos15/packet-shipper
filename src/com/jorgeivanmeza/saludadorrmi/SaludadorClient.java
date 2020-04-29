package com.jorgeivanmeza.saludadorrmi;

import java.rmi.*;
import java.rmi.registry.*;

/*
java -cp .						\
     -Djava.security.policy=client.policy		\
     SaludadorClient
*/

public class SaludadorClient 
{
    public static void main(String args[])
    {
        // El archivo client.policy debe estar ubicado en el directorio
        // raíz del proyecto
        
        System.out.println("[Client] Especificando el nombre de la politica de seguridad.");
        
        System.setProperty("java.security.policy", "client.policy");
        
        final String HOST = "127.0.0.1";

        System.out.println("[Cliente] Estableciendo el manejador de seguridad.");
        
        if (System.getSecurityManager() == null)
           // System.setSecurityManager(new RMISecurityManager());
           System.setSecurityManager(new SecurityManager());

        Saludable saludador = null;

        try
        {
            System.out.println("[Cliente] Obteniendo la referencia al RMI Registry.");
            
            Registry registry = LocateRegistry.getRegistry(HOST);
            
            System.out.println("[Cliente] Buscando la referencia del objeto remoto en el RMI Registry.");
            
            saludador = (Saludable) registry.lookup("MySaludador");

            // saludador = (Saludable) Naming.lookup("//localhost.Saludable");
            // saludador = (Saludable) Naming.lookup("//localhost.Saludable");
            // saludador = (Saludable) Naming.lookup("//localhost/Saludador");

            System.out.println("[Cliente] Invocando el objeto remoto en múltiples ocasiones.");
            
            System.out.println("Hola a las 08:00 am: " + saludador.saludar(8,  "Jorge"));
            System.out.println("Hola a las 16:00 am: " + saludador.saludar(16, "Jorge"));
            System.out.println("Hola a las 20:00 am: " + saludador.saludar(20, "Jorge"));
        } 
        catch(RemoteException e) 
        {
            System.out.println("[Cliente] (RemoteException): " + e.getMessage());
        }
        catch(NotBoundException e) 
        {
            System.out.println("[Cliente] (NotBoundException): " + e.getMessage());
        }
    }
}
