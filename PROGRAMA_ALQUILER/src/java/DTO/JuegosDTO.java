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
public class JuegosDTO {

    private int id_juego;
    private String titulo;
    private String genero;
    private Date year;
    private String protagonistas;
    private String director;
    private String productor;
    private String tecnologia;
    private long precio_alquiler;

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getProtagonistas() {
        return protagonistas;
    }

    public void setProtagonistas(String protagonistas) {
        this.protagonistas = protagonistas;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public long getPrecio_alquiler() {
        return precio_alquiler;
    }

    public void setPrecio_alquiler(long precio_alquiler) {
        this.precio_alquiler = precio_alquiler;
    }

    @Override
    public String toString() {
        return "Juegos{" + "id_juego=" + id_juego + ", titulo=" + titulo + ", genero=" + genero + ", year=" + year + ", protagonistas=" + protagonistas + ", director=" + director + ", productor=" + productor + ", tecnologia=" + tecnologia + ", precio_alquiler=" + precio_alquiler + '}';
    }

}
