package com.jorgeivanmeza.saludadorrmi;

import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

/*
java -cp . 					\
     -Djava.security.policy=server.policy	\
     SaludadorServer 
*/

public class SaludadorServer
{
    public static void main(String args[])
    {
        // Reemplazar la dirección IP o FQDN con el correspondiente valor del servidor actual.
        // Para evitar el escribir de manera estática la dirección IP de la interfaz de red 
        // activa del servidor se recomienda como mejor práctica utilizar un archivo de 
        // configuración o utilizar la opción "-Djava.rmi.server.hostname=IP_DEL_SERVIDOR" 
        // durante la ejecución del servidor.  Ver otras propiedades en 
        // https://docs.oracle.com/javase/8/docs/technotes/guides/rmi/javarmiproperties.html        
        
        System.out.println("[Servidor] Establecer a través de cual interfaz de red del servidor ser recibirán peticiones.");

        String ipServidor = "127.0.0.1";
        // Modificar!        ^^^^^^^^^^^^^^^
        
        System.setProperty("java.rmi.server.hostname", ipServidor);
        
        // El archivo server.policy debe estar ubicado en el directorio
        // raíz del proyecto

        System.out.println("[Servidor] Especificando el nombre de la politica de seguridad.");
        
        System.setProperty("java.security.policy", "server.policy");
        
        System.out.println("[Servidor] Estableciendo el manejador de seguridad.");
        
        if (System.getSecurityManager() == null)
                // System.setSecurityManager(new RMISecurityManager());
                System.setSecurityManager(new SecurityManager());

        try
        {
            System.out.println("[Servidor] Instanciado el objeto que va a ser accedido remotamente.");
            
            Saludable unSaludable = new SaludableImpl();

            System.out.println("[Servidor] Creando el 'stub' del objeto que va a ser accedido remotamente.");
            
            Saludable stub = (Saludable) UnicastRemoteObject.exportObject(unSaludable,0);

            // Puerto por defecto del RMI Registry: 1099
            
            System.out.println("[Servidor] Iniciando su propio servicio de RMI Registry.");
            
            Registry registry = LocateRegistry.createRegistry(1099);
            
            /*
            // Localizar un 'registry' ya existente, para esto se requiere que
            // previamente se haya ejecutado: SET CLASSPATH=""; rmiregistry &

            System.out.println("[Servidor] Localizando un servicio de RMI Registry ya existente.");
            
            Registry registry = LocateRegistry.getRegistry();
            */
            
            System.out.println("[Servidor] Publicando el stub del objeto remoto en el RMI Registry.");
            
            registry.rebind("MySaludador", stub);

            // Naming.rebind("Saludador", stub);   /**/
            // Naming.rebind("//localhost.Saludador", stub);   /**/
            // Naming.rebind("//localhost/Saludador", stub);   /**/

            System.out.println("[Servidor] Servidor listo!");
        }
        catch(Exception e) 
        {
            System.out.println("[Servidor] (exception): " + e.getMessage());
        }
    }
}