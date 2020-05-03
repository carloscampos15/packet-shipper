/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Georeferenciacion;

import Modelos.Ciudad;
import Modelos.Constante;
import Modelos.Paquete;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class BufferGeoreferenciador extends Thread {

    private ArrayList<Paquete> paquetes;
    private GeoreferenciadorImpl georeferenciadorImpl;

    public BufferGeoreferenciador(GeoreferenciadorImpl georeferenciadorImpl) {
        this.georeferenciadorImpl = georeferenciadorImpl;
        this.paquetes = new ArrayList<>();
    }

    public void agregarPaquete(Paquete paquete) {
        this.paquetes.add(paquete);
    }

    private Paquete asignarCiudad(Paquete paquete) {
        Ciudad ciudad = this.georeferenciadorImpl.obtenerCiudad(paquete.getCiudadReceptor(), paquete.getDepartamentoReceptor());
        paquete.setLatitudReceptor(ciudad.getLatitud());
        paquete.setLongitudReceptor(ciudad.getLongitud());
        return paquete;
    }

    private void georeferenciar() {
        while (true) {
            if (paquetes.size() >= 1) {
                try {
                    System.out.println("###########################");
                    System.out.println("Iniciando georeferenciacion");

                    long inicio = System.currentTimeMillis();
                    Thread.sleep(Constante.TIEMPO_REFERENCIADOR);
                    Paquete paquete = paquetes.get(0);
                    paquete = this.asignarCiudad(paquete);

                    long fin = System.currentTimeMillis();
                    double tiempo = (double) ((fin - inicio) / 1000);
                    System.out.println("fin: " + tiempo + " segundos");

                    this.paquetes.remove(paquete);
                    
                    this.georeferenciadorImpl.encolarPaquete(paquete);
                } catch (InterruptedException ex) {
                    System.out.println("[Servidor] (InterruptedException) " + ex.getMessage());
                }
            }else{
                System.getProperties();
            }
        }
    }

    @Override
    public void run() {
        georeferenciar();
    }
}
