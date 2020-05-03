/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;

/**
 *
 * @author carlo
 */
public class Ubicacion implements Serializable{

    private String latitud;
    private String longituf;

    public Ubicacion(String latitud, String longituf) {
        this.latitud = latitud;
        this.longituf = longituf;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongituf() {
        return longituf;
    }

    public void setLongituf(String longituf) {
        this.longituf = longituf;
    }

}
