/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Modelos.Ciudad;
import Recepcion.Recepcion;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class ClienteRecepcion {

    private Recepcion recepcion;

    public ClienteRecepcion(String ip) {
        try {
            System.setProperty("java.security.policy", "client.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            Registry registry = LocateRegistry.getRegistry(ip, 1710);
            this.recepcion = (Recepcion) registry.lookup("Recepcion");
        } catch (RemoteException ex) {
            System.out.println("[Cliente] (RemoteException): " + ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println("[Cliente] (NotBoundException): " + ex.getMessage());
        }
    }

    public ArrayList<Ciudad> obtenerCiudades() {
        try {
            return recepcion.obtenerCiudades();
        } catch (RemoteException ex) {
            System.out.println("[Cliente] (RemoteException): " + ex.getMessage());
        }
        return null;
    }
    
}
