/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Georeferenciacion;

import Georeferenciacion.Georeferenciador;
import Modelos.Ciudad;
import Modelos.Departamento;
import Modelos.Paquete;
import Recepcion.Recepcion;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 * 
 *
 * @author Karen Dayanna Castaño Orjuela
 * @author Carlos Alberto Campos Armero
 */
public class ClienteGeorefereciador {

    private Georeferenciador georeferenciador;

    public ClienteGeorefereciador(String ip) {
        try {
            System.setProperty("java.security.policy", "client.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            Registry registry = LocateRegistry.getRegistry(ip, 1099);
            this.georeferenciador = (Georeferenciador) registry.lookup("Georeferenciador");
        } catch (RemoteException ex) {
            System.out.println("[Cliente] (RemoteException): " + ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println("[Cliente] (NotBoundException): " + ex.getMessage());
        }
    }

    public ArrayList<Departamento> obtenerDepartamentos() {
        try {
            return georeferenciador.obtenerDepartamentos();
        } catch (RemoteException ex) {
            System.out.println("[Cliente] (RemoteException): " + ex.getMessage());
        }
        return null;
    }

    public ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) {
        try {
            return georeferenciador.obtenerCiudades(nombreDepartamento);
        } catch (RemoteException ex) {
            System.out.println("[Cliente] (RemoteException): " + ex.getMessage());
        }
        return null;
    }

    public boolean georeferenciarPaquete(Recepcion Recepcion, Paquete paquete) {
        try {
            return georeferenciador.georeferenciarPaquete(Recepcion, paquete);
        } catch (RemoteException ex) {
            System.out.println("[Cliente] (RemoteException): " + ex.getMessage());
        }
        return false;
    }
}
