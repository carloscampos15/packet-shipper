/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bodega;

import Georeferenciacion.Georeferenciador;
import Modelos.Ciudad;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class BodegaCliente {

    public static void main(String[] args) {
        System.out.println("[Cliente] Especificando el nombre de la politica de seguridad.");
        System.setProperty("java.security.policy", "client.policy");
        
        final String HOST = "127.0.0.1";
        
        System.out.println("[Cliente] Estableciendo el manejador de seguridad.");
        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());
        
        Georeferenciador georeferenciador = null;
        
        try{
            System.out.println("[Cliente] Obteniendo la referencia al RMI Registry.");
            Registry registry = LocateRegistry.getRegistry(HOST);
            
            System.out.println("[Cliente] Buscando la referencia del objeto remoto en el RMI Registry.");
            georeferenciador = (Georeferenciador) registry.lookup("Georeferenciador");
            
            System.out.println("[Cliente] Invocando el objeto remoto en múltiples ocasiones.");
            
            ArrayList<Ciudad> ciudades = georeferenciador.obtenerCiudades();
            for(Ciudad ciudad : ciudades)
                System.out.println(ciudad.getNombre());
        }catch(RemoteException e){
            System.out.println(" (RemoteException): " + e.getMessage());
        }catch(NotBoundException e){
            System.out.println(" (NotBoundException): " + e.getMessage());
        }
    }
}
