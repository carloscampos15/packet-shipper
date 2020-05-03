/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Georeferenciacion;

import Modelos.Ciudad;
import Modelos.Departamento;
import Modelos.Paquete;
import Recepcion.Recepcion;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 
 *
 * @author Karen Dayanna Castaño Orjuela
 * @author Carlos Alberto Campos Armero
 */
public interface Georeferenciador extends Remote {
    ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) throws RemoteException;
    ArrayList<Departamento> obtenerDepartamentos() throws RemoteException;
    boolean georeferenciarPaquete(Recepcion recepcion, Paquete paquete) throws RemoteException;
}