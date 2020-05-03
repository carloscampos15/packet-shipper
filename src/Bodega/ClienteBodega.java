/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bodega;

import Bodega.Bodega;
import Modelos.Paquete;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author carlo
 */
public class ClienteBodega {

    private Bodega bodega;

    public ClienteBodega(String ip) {
        try {
            System.setProperty("java.security.policy", "client.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            Registry registry = LocateRegistry.getRegistry(ip, 1525);
            this.bodega = (Bodega) registry.lookup("Bodega");
        } catch (RemoteException ex) {
            System.out.println("[Cliente] (RemoteException): " + ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println("[Cliente] (NotBoundException): " + ex.getMessage());
        }
    }

    public boolean almacenarPaquete(Paquete paquete) {
        try {
            return bodega.almacenarPaquete(paquete);
        } catch (RemoteException ex) {
            System.out.println("[Cliente] (RemoteException): " + ex.getMessage());
        }
        return false;
    }
}
