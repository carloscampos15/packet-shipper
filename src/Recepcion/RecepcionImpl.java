/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recepcion;

import Modelos.Ciudad;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class RecepcionImpl implements Recepcion{

    private ClienteGeorefereciador clienteGeorefereciador;
    
    public RecepcionImpl(String ip) {
        super();
        this.clienteGeorefereciador = new ClienteGeorefereciador(ip);
    }

    @Override
    public ArrayList<Ciudad> obtenerCiudades() throws RemoteException {
        return this.clienteGeorefereciador.obtenerCiudades();
    }
}
