/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Georeferenciacion;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author carlo
 */
public class GeoreferenciadorServidor {

    private String ip;

    public GeoreferenciadorServidor(String ip) {
        this.ip = ip;
    }

    public void iniciarServicios() {
        System.out.println("[Servidor] Establecer a través de cual interfaz de red del servidor ser recibirán peticiones.");
        System.setProperty("java.rmi.server.hostname", this.ip);
        
        System.out.println("[Servidor] Especificando el nombre de la politica de seguridad.");
        System.setProperty("java.security.policy", "server.policy");
        
        System.out.println("[Servidor] Estableciendo el manejador de seguridad.");
        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());
        
        try{
            System.out.println("[Servidor] Instanciado el objeto que va a ser accedido remotamente.");
            Georeferenciador georeferenciador = new GeoreferenciadorImpl();
            
            System.out.println("[Servidor] Creando el 'stub' del objeto que va a ser accedido remotamente.");
            Georeferenciador stub = (Georeferenciador) UnicastRemoteObject.exportObject(georeferenciador,0);
            
            System.out.println("[Servidor] Iniciando su propio servicio de RMI Registry.");
            Registry registry = LocateRegistry.createRegistry(1099);
            
            System.out.println("[Servidor] Publicando el stub del objeto remoto en el RMI Registry.");
            registry.rebind("Georeferenciador", stub);
            
            System.out.println("[Servidor] Servidor listo!");
        }catch(Exception e) {
            System.out.println("[Servidor] (exception): " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        GeoreferenciadorServidor georeferenciadorServidor = new GeoreferenciadorServidor("127.0.0.1");
        georeferenciadorServidor.iniciarServicios();
    }
}
