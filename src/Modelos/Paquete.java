/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author carlo
 */
public class Paquete {
    private String nombreEmisor;
    private String ciudadEmisor;
    private String nombreReceptor;
    private String ciudadReceptor;
    private String departamentoReceptor;
    private String latitudReceptor;
    private String longitudReceptor;
    private String fechaRecibido;
    private String fechaEnvio;
    private String estado;
    private float peso;

    public Paquete(String nombreEmisor, String ciudadEmisor, String nombreReceptor, String ciudadReceptor, String departamentoReceptor, float peso) {
        this.nombreEmisor = nombreEmisor;
        this.ciudadEmisor = ciudadEmisor;
        this.nombreReceptor = nombreReceptor;
        this.ciudadReceptor = ciudadReceptor;
        this.departamentoReceptor = departamentoReceptor;
        this.peso = peso;
        this.estado = "";
    }
}
