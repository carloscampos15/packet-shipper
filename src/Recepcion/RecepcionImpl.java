/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recepcion;

import Bodega.ClienteBodega;
import Georeferenciacion.ClienteGeorefereciador;
import Modelos.Ciudad;
import Modelos.Departamento;
import Modelos.Paquete;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 
 *
 * @author Karen Dayanna Castaño Orjuela
 * @author Carlos Alberto Campos Armero
 */
public class RecepcionImpl implements Recepcion{

    private ClienteGeorefereciador clienteGeorefereciador;
    private ClienteBodega clienteBodega;
    private BufferRecepcion bufferRecepcion;
    
    public RecepcionImpl(String ip) {
        super();
        this.clienteGeorefereciador = new ClienteGeorefereciador(ip);
        this.clienteBodega = new ClienteBodega(ip);
        this.bufferRecepcion = new BufferRecepcion(this);
        this.bufferRecepcion.start();
    }

    @Override
    public ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) throws RemoteException {
        return this.clienteGeorefereciador.obtenerCiudades(nombreDepartamento);
    }

    @Override
    public ArrayList<Departamento> obtenerDepartamentos() throws RemoteException {
        return this.clienteGeorefereciador.obtenerDepartamentos();
    }

    @Override
    public boolean registrarPaquete(Paquete paquete) throws RemoteException {
        this.bufferRecepcion.agregarPaquete(paquete);
        return true;
    }
    
    @Override
    public boolean georeferenciarPaquete(Paquete paquete){
        return this.clienteGeorefereciador.georeferenciarPaquete(this, paquete);
    }
    
    public boolean almacenarPaquete(Paquete paquete){
        //AQUI DEBO ENVIAR A LA BODEGA EL PAQUETE
        this.clienteBodega.almacenarPaquete(paquete);
        return true;
    }
}
