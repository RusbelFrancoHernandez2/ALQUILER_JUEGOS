/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author rfranco
 */
public class Personas {
    
    private String id_personas;
    private String nombre;
    private String tipo_documento;
    private String numero_documento;
    private Date fecha_nacimiento;
    private String direccion;
    private int celular;

    public String getId_personas() {
        return id_personas;
    }

    public void setId_personas(String id_personas) {
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Personas{" + "id_personas=" + id_personas + ", nombre=" + nombre + ", tipo_documento=" + tipo_documento + ", numero_documento=" + numero_documento + ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion + ", celular=" + celular + '}';
    }    
    
}
