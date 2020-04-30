/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recepcion;

import Modelos.Paquete;
import java.util.ArrayList;



/**
 *
 * @author carlo
 */
public class BufferPaquetes{
    private ArrayList<Paquete> paquetes;
    private final static int TIEMPO = 10000;

    public BufferPaquetes() {
        paquetes = new ArrayList<>();
    }
    
    public void encolarPaquete(Paquete paquete){
        paquetes.add(paquete);
    }
}
