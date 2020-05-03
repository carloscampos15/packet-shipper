/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bodega;

import Modelos.Paquete;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class BodegaImpl implements Bodega {

    private ArrayList<Paquete> paquetesEnBodega;
    private BufferBodega bufferBodega;

    public BodegaImpl() {
        this.paquetesEnBodega = new ArrayList<>();
        this.bufferBodega = new BufferBodega(this);
        this.bufferBodega.start();
    }

    @Override
    public boolean almacenarPaquete(Paquete paquete) throws RemoteException {
        this.bufferBodega.agregarPaquete(paquete);
        return true;
    }

    public boolean almacenarEnBodega(Paquete paquete) {
        this.paquetesEnBodega.add(paquete);
        return true;
    }

}
