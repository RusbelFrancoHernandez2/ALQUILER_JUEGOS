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
public class Alquiler {
    
    private String id_alquiler;
    private String id_juego;
    private String id_persona;
    private Date fecha_entrega;
    private Date fecha_alquiler;
    private Double valor_venta;

    public String getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(String id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public String getId_juego() {
        return id_juego;
    }

    public void setId_juego(String id_juego) {
        this.id_juego = id_juego;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Date getFecha_alquiler() {
        return fecha_alquiler;
    }

    public void setFecha_alquiler(Date fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    public Double getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(Double valor_venta) {
        this.valor_venta = valor_venta;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "id_alquiler=" + id_alquiler + ", id_juego=" + id_juego + ", id_persona=" + id_persona + ", fecha_entrega=" + fecha_entrega + ", fecha_alquiler=" + fecha_alquiler + ", valor_venta=" + valor_venta + '}';
    }    
    
}
