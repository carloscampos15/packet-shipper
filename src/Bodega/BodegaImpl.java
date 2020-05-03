/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bodega;

import Modelos.Camion;
import Modelos.Constante;
import Modelos.Paquete;
import Modelos.Ubicacion;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class BodegaImpl implements Bodega {

    private ArrayList<Paquete> paquetesEnBodega;
    private ArrayList<Camion> camiones;
    private BufferBodega bufferBodega;

    public BodegaImpl() {
        this.paquetesEnBodega = new ArrayList<>();
        this.camiones = new ArrayList<>();
        this.bufferBodega = new BufferBodega(this);
        this.bufferBodega.start();
    }

    @Override
    public boolean almacenarPaquete(Paquete paquete) throws RemoteException {
        this.bufferBodega.agregarPaquete(paquete);
        return true;
    }

    public boolean almacenarEnBodega(Paquete paquete) {
        paquete.setEstado(Constante.ALMACENADO);
        this.paquetesEnBodega.add(paquete);
        return true;
    }

    @Override
    public ArrayList<Paquete> obtenerPaquetesBodega() throws RemoteException {
        ArrayList<Paquete> paquetes = new ArrayList<>();
        for(Paquete paquete : this.paquetesEnBodega){
            paquetes.add(paquete);
        }
        return paquetes;
    }

    @Override
    public boolean solicitarEnvioPaquetes(Ubicacion ubicacion, double peso) throws RemoteException {
        this.bufferBodega.agregarPaquetesEnviar(this.paquetesEnBodega, ubicacion, peso);
        return true;
    }
    
    public boolean enviarPaquetes(ArrayList<Paquete> paquetesEnviar, ArrayList<Paquete> paquetesEnBodega, double capacidad){
        this.paquetesEnBodega = paquetesEnBodega;
        camiones.add(new Camion(camiones.size()+1, capacidad, paquetesEnviar));
        return true;
    }

    @Override
    public ArrayList<Camion> obtenerCamiones() throws RemoteException {
        return this.camiones;
    }
}
