/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recepcion;

import Modelos.Ciudad;
import Modelos.Departamento;
import Modelos.Paquete;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 
 *
 * @author Karen Dayanna Castaño Orjuela
 * @author Carlos Alberto Campos Armero
 */
public interface Recepcion extends Remote {
    ArrayList<Departamento> obtenerDepartamentos() throws RemoteException;
    ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) throws RemoteException;
    boolean registrarPaquete(Paquete paquete) throws RemoteException;
    boolean georeferenciarPaquete(Paquete paquete) throws RemoteException;
}
