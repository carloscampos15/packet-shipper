/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Georeferenciacion;

import Modelos.Ciudad;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class GeoreferenciadorImpl implements Georeferenciador {

    public GeoreferenciadorImpl() {
        super();
        UbicacionBD.connect();
    }

    @Override
    public ArrayList<Ciudad> obtenerCiudades() throws RemoteException {
        try {
            return UbicacionBD.obtenerCiudades();
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
}
