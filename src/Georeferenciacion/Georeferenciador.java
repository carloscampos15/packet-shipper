/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Georeferenciacion;

import Modelos.Ciudad;
import Modelos.Departamento;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public interface Georeferenciador extends Remote {
    ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) throws RemoteException;
    ArrayList<Departamento> obtenerDepartamentos() throws RemoteException;
    Ciudad obtenerCiudad(String nombreCiudad, String nombreDepartamento) throws RemoteException;
}