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
public class Ciudad implements Serializable{
    private String nombre;
    private String departamento;
    private String latitud;
    private String longitud;
    private int codigo;

    public Ciudad(String nombre, String departamento, String latitud, String longitud, int codigo) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.latitud = latitud;
        this.longitud = longitud;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
