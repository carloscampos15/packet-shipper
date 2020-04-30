/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Georeferenciacion;

import Modelos.Ciudad;
import Modelos.Departamento;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 *
 * @author Karen Dayanna Castaño Orjuela
 * @author Carlos Alberto Campos Armero
 */
public class GeoreferenciadorImpl implements Georeferenciador {

    public GeoreferenciadorImpl() {
        super();
        UbicacionBD.connect();
    }

    @Override
    public ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) throws RemoteException {
        try {
            return UbicacionBD.obtenerCiudades(nombreDepartamento);
        } catch (SQLException ex) {
            System.out.println("[Servidor] (SQLException)");
        }
        return null;
    }

    @Override
    public Ciudad obtenerCiudad(String nombreCiudad, String nombreDepartamento) throws RemoteException {
        try {
            return UbicacionBD.obtenerCiudad(nombreCiudad, nombreDepartamento);
        } catch (SQLException ex) {
            System.out.println("[Servidor] (SQLException)");
        }
        return null;
    }

    @Override
    public ArrayList<Departamento> obtenerDepartamentos() throws RemoteException {
        try {
            return UbicacionBD.obtenerDepartamentos();
        } catch (SQLException ex) {
            System.out.println("[Servidor] (SQLException)");
        }
        return null;
    }
}
