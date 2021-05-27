/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;



/**
 *
 * @author rfranco
 */
public class PersonaDTO {
    
    private int id_personas;
    private String nombre;
    private String tipo_documento;
    private String numero_documento;
    private Date fecha_registro;
    private String direccion;
    private long celular;

    public int getId_personas() {
        return id_personas;
    }

    public void setId_personas(int id_personas) {
        this.id_personas = id_personas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Personas{" + "id_personas=" + id_personas + ", nombre=" + nombre + ", tipo_documento=" + tipo_documento + ", numero_documento=" + numero_documento + ", fecha_registro=" + fecha_registro + ", direccion=" + direccion + ", celular=" + celular + '}';
    }    
    
}
