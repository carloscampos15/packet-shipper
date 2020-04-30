/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recepcion;

import Modelos.Ciudad;
import Modelos.Departamento;
import Modelos.Paquete;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class RecepcionImpl implements Recepcion{

    private ClienteGeorefereciador clienteGeorefereciador;
    private BufferPaquetes bufferPaquetes;
    
    public RecepcionImpl(String ip) {
        super();
        this.clienteGeorefereciador = new ClienteGeorefereciador(ip);
        this.bufferPaquetes = new BufferPaquetes();
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
        //Primer timer de 5 segundos
        Ciudad ciudad = this.clienteGeorefereciador.obtenerCiudad(paquete.getCiudadReceptor(), paquete.getDepartamentoReceptor());
        if(ciudad != null){
            paquete.setLatitudReceptor(ciudad.getLatitud());
            paquete.setLongitudReceptor(ciudad.getLongitud());
            
            //Segundo timer de 10 segundos
            bufferPaquetes.encolarPaquete(paquete);
            
            return true;
        }
        return false;
    }
    
    
}
