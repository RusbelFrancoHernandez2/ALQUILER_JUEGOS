/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.JuegosDAO;
import DAO.PersonaDAO;
import DTO.JuegosDTO;
import DTO.PersonaDTO;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author rfranco
 */
@WebService(serviceName = "WebServiceAlquiler")
public class WebServiceAsesor {

    /**
     * Web service operation
     * @param nombre
     * @param tipo_documento
     * @param numero_documento
     * @param fecha_nacimiento
     * @param direccion
     * @param celular
     * @return 
     */
    @WebMethod(operationName = "creacionPersona")
    public String creacionPersona(@WebParam(name = "nombre") String nombre, @WebParam(name = "tipo_documento") String tipo_documento, @WebParam(name = "numero_documento") String numero_documento, @WebParam(name = "fecha_nacimiento") String fecha_nacimiento, @WebParam(name = "direccion") String direccion, @WebParam(name = "celular") long celular) {
       
        PersonaDAO personaDAO =new PersonaDAO();        
        PersonaDTO personas = new PersonaDTO();
                
        personas.setNombre(nombre);
        personas.setTipo_documento(tipo_documento);
        personas.setNumero_documento(numero_documento);
        personas.setFecha_nacimiento(new Date(fecha_nacimiento));
        personas.setDireccion(direccion);
        personas.setCelular(celular);
        
        personaDAO.insert(personas);
        return "ok";
    }

    /**
     * Web service operation
     * @param titulo
     * @param genero
     * @param year
     * @param protagonistas
     * @param director
     * @param productor
     * @param tecnologia
     * @param precio_alquiler
     * @return 
     */
    @WebMethod(operationName = "creacionJuego")
    public String creacionJuego(@WebParam(name = "titulo") String titulo, @WebParam(name = "genero") String genero, @WebParam(name = "year") String year, @WebParam(name = "protagonistas") String protagonistas, @WebParam(name = "director") String director, @WebParam(name = "productor") String productor, @WebParam(name = "tecnologia") String tecnologia, @WebParam(name = "precio_alquiler") long precio_alquiler) {
          
           JuegosDAO crud = new JuegosDAO();
           JuegosDTO juegos = new JuegosDTO();
           
           juegos.setTitulo(titulo);
           juegos.setGenero(genero);
           juegos.setYear(new Date(year));
           juegos.setProtagonistas(protagonistas);
           juegos.setDirector(director);
           juegos.setProductor(productor);
           juegos.setTecnologia(tecnologia);           
           juegos.setPrecio_alquiler(precio_alquiler);
           crud.insert(juegos);
           
        return "ok";
    }

    /**
     * Web service operation
     * @param titulo
     * @param genero
     * @param year
     * @param protagonistas
     * @param director
     * @param productor
     * @param tecnologia
     * @param precio_alquiler
     * @param id_juego
     * @return 
     */
    @WebMethod(operationName = "updateJuego")
    public String updateJuego(@WebParam(name = "titulo") String titulo, @WebParam(name = "genero") String genero, @WebParam(name = "year") String year, @WebParam(name = "protagonistas") String protagonistas, @WebParam(name = "director") String director, @WebParam(name = "productor") String productor, @WebParam(name = "tecnologia") String tecnologia, @WebParam(name = "precio_alquiler") long precio_alquiler, @WebParam(name = "id_juego") int id_juego) {
           
           JuegosDAO crud = new JuegosDAO();
           JuegosDTO juegos = new JuegosDTO();
           
           juegos.setId_juego(id_juego);
           juegos.setTitulo(titulo);
           juegos.setGenero(genero);
           juegos.setYear(new Date(year));
           juegos.setProtagonistas(protagonistas);
           juegos.setDirector(director);
           juegos.setProductor(productor);
           juegos.setTecnologia(tecnologia);           
           juegos.setPrecio_alquiler(precio_alquiler);
           crud.update(juegos);
           
        return "ok";
    }
}
