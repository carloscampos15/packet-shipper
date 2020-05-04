/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bodega;

import Modelos.Constante;
import Modelos.Paquete;
import Modelos.Ubicacion;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author carlo
 */
public class BufferBodega extends Thread {

    private ArrayList<Paquete> paquetesAlmacenar;
    private ArrayList<Paquete> paquetesEnviar;
    private BodegaImpl bodegaImpl;
    private Ubicacion ubicacionEnvio;
    private boolean state;
    private double pesoEnvio;

    public BufferBodega(BodegaImpl bodegaImpl) {
        this.bodegaImpl = bodegaImpl;
        this.paquetesAlmacenar = new ArrayList<>();
        this.state = true;
    }

    public void agregarPaquete(Paquete paquete) {
        this.paquetesAlmacenar.add(paquete);
    }

    public void agregarPaquetesEnviar(ArrayList<Paquete> paquetesEnviar, Ubicacion ubicacion, double peso) {
        this.paquetesEnviar = paquetesEnviar;
        this.ubicacionEnvio = ubicacion;
        this.pesoEnvio = peso;
    }

    private void procesarEnvio() {
        ArrayList<Paquete> paquetesBodega = new ArrayList<>();
        for (Paquete paquete : paquetesEnviar) {
            paquete.setDistanciaDestino(ubicacionEnvio.calcularDistancia(paquete.getUbicacion().getLatitud(),
                    ubicacionEnvio.getLatitud(), paquete.getUbicacion().getLongitud(), ubicacionEnvio.getLongitud()));
        }
        //Primero ordernar por la distancia que hay al destino
        Collections.sort(paquetesEnviar);
        double pesoTotal = 0;
        for (Paquete paquete : paquetesEnviar) {
            if (pesoTotal + paquete.getPeso() <= pesoEnvio) {
                pesoTotal += paquete.getPeso();
                paquete.setEstado(Constante.ENVIADO);
                paquete.setFechaEnvio(java.time.LocalDate.now()+"");
            } else {
                paquetesBodega.add(paquete);
                paquetesEnviar.remove(paquete);
            }
        }
        this.bodegaImpl.enviarPaquetes(this.paquetesEnviar, paquetesBodega, pesoEnvio);
        this.state = true;
    }

    private void procesosBodega() {
        while (true) {
            if (paquetesAlmacenar.size() >= 1) {
                try {
                    System.out.println("##################################");
                    System.out.println("Iniciando almacenamiento en bodega");

                    long inicio = System.currentTimeMillis();
                    Thread.sleep(Constante.TIEMPO_ALMACENAMIENTO);
                    Paquete paquete = paquetesAlmacenar.get(0);

                    long fin = System.currentTimeMillis();
                    double tiempo = (double) ((fin - inicio) / 1000);
                    System.out.println("fin: " + tiempo + " segundos");

                    this.paquetesAlmacenar.remove(paquete);

                    this.bodegaImpl.almacenarEnBodega(paquete);
                } catch (InterruptedException ex) {
                    System.out.println("[Servidor] (InterruptedException) " + ex.getMessage());
                }
            }
            if (paquetesEnviar != null && this.state) {
                try {
                    this.state = false;
                    System.out.println("##################################");
                    System.out.println("Iniciando preparacion de envio");
                    
                    long inicio = System.currentTimeMillis();
                    Thread.sleep(Constante.TIEMPO_PREPARACION_ENVIO);

                    this.procesarEnvio();

                    long fin = System.currentTimeMillis();
                    double tiempo = (double) ((fin - inicio) / 1000);
                    System.out.println("fin: " + tiempo + " segundos");

                    this.paquetesEnviar = null;
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
        procesosBodega();
    }
}
