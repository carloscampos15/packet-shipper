/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bodega;

import Modelos.Constante;
import Modelos.Paquete;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class BufferBodega extends Thread {

    private ArrayList<Paquete> paquetes;
    private BodegaImpl bodegaImpl;

    public BufferBodega(BodegaImpl bodegaImpl) {
        this.bodegaImpl = bodegaImpl;
        this.paquetes = new ArrayList<>();
    }

    public void agregarPaquete(Paquete paquete) {
        this.paquetes.add(paquete);
    }

    private void almacenarEnBodega() {
        while (true) {
            if (paquetes.size() >= 1) {
                try {
                    System.out.println("##################################");
                    System.out.println("Iniciando almacenamiento en bodega");

                    long inicio = System.currentTimeMillis();
                    Thread.sleep(Constante.TIEMPO_ALMACENAMIENTO);
                    Paquete paquete = paquetes.get(0);

                    long fin = System.currentTimeMillis();
                    double tiempo = (double) ((fin - inicio) / 1000);
                    System.out.println("fin: " + tiempo + " segundos");

                    this.paquetes.remove(paquete);
                    
                    this.bodegaImpl.almacenarEnBodega(paquete);
                } catch (InterruptedException ex) {
                    System.out.println("[Servidor] (InterruptedException) " + ex.getMessage());
                }
            } else {
                System.getProperties();
            }
        }
    }

    @Override
    public void run() {
        almacenarEnBodega();
    }
}
