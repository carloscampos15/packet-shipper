/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bodega;

import Modelos.Paquete;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public interface Bodega extends Remote{
    boolean almacenarPaquete(Paquete paquete) throws RemoteException;
    ArrayList<Paquete> obtenerPaquetesBodega() throws RemoteException;
}
