/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;

/**
 *
 *
 * @author Karen Dayanna Castaño Orjuela
 * @author Carlos Alberto Campos Armero
 */
public class Paquete implements Serializable {

    private String nombreEmisor;
    private String departamentoEmisor;
    private String ciudadEmisor;
    private String nombreReceptor;
    private String departamentoReceptor;
    private String ciudadReceptor;
    //private Ubicacion ubicacion;
    private String latitudReceptor;
    private String longitudReceptor;
    private String fechaRecibido;
    private String fechaEnvio;
    private String estado;
    private float peso;
    
    public Paquete(String nombreEmisor, String departamentoEmisor, String ciudadEmisor, String nombreReceptor, String departamentoReceptor, String ciudadReceptor, float peso) {
        this.nombreEmisor = nombreEmisor;
        this.ciudadEmisor = ciudadEmisor;
        this.nombreReceptor = nombreReceptor;
        this.ciudadReceptor = ciudadReceptor;
        this.departamentoReceptor = departamentoReceptor;
        this.peso = peso;
        this.estado = "";
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public String getDepartamentoEmisor() {
        return departamentoEmisor;
    }

    public void setDepartamentoEmisor(String departamentoEmisor) {
        this.departamentoEmisor = departamentoEmisor;
    }

    public String getCiudadEmisor() {
        return ciudadEmisor;
    }

    public void setCiudadEmisor(String ciudadEmisor) {
        this.ciudadEmisor = ciudadEmisor;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public String getDepartamentoReceptor() {
        return departamentoReceptor;
    }

    public void setDepartamentoReceptor(String departamentoReceptor) {
        this.departamentoReceptor = departamentoReceptor;
    }

    public String getCiudadReceptor() {
        return ciudadReceptor;
    }

    public void setCiudadReceptor(String ciudadReceptor) {
        this.ciudadReceptor = ciudadReceptor;
    }

    public String getLatitudReceptor() {
        return latitudReceptor;
    }

    public void setLatitudReceptor(String latitudReceptor) {
        this.latitudReceptor = latitudReceptor;
    }

    public String getLongitudReceptor() {
        return longitudReceptor;
    }

    public void setLongitudReceptor(String longitudReceptor) {
        this.longitudReceptor = longitudReceptor;
    }

    public String getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(String fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

//    public Ubicacion getUbicacion() {
//        return ubicacion;
//    }
//
//    public void setUbicacion(Ubicacion ubicacion) {
//        this.ubicacion = ubicacion;
//    }
}
