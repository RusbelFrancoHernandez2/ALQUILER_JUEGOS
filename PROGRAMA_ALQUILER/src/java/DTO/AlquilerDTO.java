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
public class AlquilerDTO {
    
    private int id_alquiler;
    private int id_juego;
    private int id_persona;
    private Date fecha_entrega;
    private Date fecha_registro;
    private String entregado;
    private long valor_venta;

    public int getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(int id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public long getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(long valor_venta) {
        this.valor_venta = valor_venta;
    }

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }

    @Override
    public String toString() {
        return "AlquilerDTO{" + "id_alquiler=" + id_alquiler + ", id_juego=" + id_juego + ", id_persona=" + id_persona + ", fecha_entrega=" + fecha_entrega + ", fecha_registro=" + fecha_registro + ", entregado=" + entregado + ", valor_venta=" + valor_venta + '}';
    }
    
}
