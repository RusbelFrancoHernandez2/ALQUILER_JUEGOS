/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.AlquilerDAO;
import DAO.JuegosDAO;
import DAO.PersonaDAO;
import DTO.AlquilerDTO;
import DTO.JuegosDTO;
import DTO.PersonaDTO;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

//    /**
//     * Web service operation
//     * @param numero_documento
//     * @param id_juego
//     * @return 
//     */
//    @WebMethod(operationName = "creacionAlquiler")
//    public String creacionAlquiler(@WebParam(name = "numero_documento") String numero_documento, @WebParam(name = "id_juego") int id_juego) {
//           
//           AlquilerDTO alquiler = new AlquilerDTO();
//           
//           Timestamp stamp1 = Timestamp.valueOf(map.get("FECHA_ENTREGA").toString());
//           Timestamp stamp2 = Timestamp.valueOf(map.get("FECHA_REGISTRO").toString());
//
//           alquiler.setId_alquiler(Integer.parseInt(map.get("ID_ALQUILER").toString()));
//           alquiler.setId_juego(Integer.parseInt(map.get("ID_JUEGO").toString()));
//           alquiler.setId_persona(Integer.parseInt(map.get("ID_PERSONA").toString()));
//           alquiler.setFecha_entrega(new Date(stamp1.getTime()));           
//           alquiler.setEntregado(map.get("ENTREGADO").toString());
//           alquiler.setValor_venta(Long.parseLong(map.get("VALOR_VENTA").toString()));
//           alquiler.setFecha_registro(new Date(stamp2.getTime()));
//        return null;
//    }

    /**
     * Web service operation
     * @param numero_documento
     * @return 
     */
    @WebMethod(operationName = "listarJuegos")
    public List<JuegosDTO> listarJuegos() {
        
        JuegosDAO crud = new JuegosDAO();
        List<JuegosDTO> list = new ArrayList<>();

        List<Map<String, ?>> listaJuegos = crud.forList();
        
        for(Map map : listaJuegos){
        
           JuegosDTO juegos = new JuegosDTO();
           Timestamp stamp = Timestamp.valueOf(map.get("YEAR").toString());
           juegos.setId_juego(Integer.parseInt(map.get("ID_JUEGO").toString()));
           juegos.setTitulo(map.get("TITULO").toString());
           juegos.setGenero(map.get("GENERO").toString());
           juegos.setYear(new Date(stamp.getTime()));
           juegos.setProtagonistas(map.get("PROTAGONISTAS").toString());
           juegos.setDirector(map.get("DIRECTOR").toString());
           juegos.setProductor(map.get("PRODUCTOR").toString());
           juegos.setTecnologia(map.get("TECNOLOGIA").toString());           
           juegos.setPrecio_alquiler(Long.parseLong(map.get("PRECIO_ALQUILER").toString()));
           list.add(juegos);
        }
        return list;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "listarAlquilerDia")
    public List<AlquilerDTO> listarAlquilerDia() {
        
        AlquilerDAO alquilerDAO = new AlquilerDAO();
        List<AlquilerDTO> listAlquiler = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Date date = new Date();
        
        String dateFormat1 = sdf.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        String dateFormat2 = sdf.format(date);
        
         List<Map<String, ?>> listaAlquiler = alquilerDAO.forListDate(dateFormat1, dateFormat2);        
                
        for(Map map : listaAlquiler){
        
           AlquilerDTO alquiler = new AlquilerDTO();
           
           Timestamp stamp1 = Timestamp.valueOf(map.get("FECHA_ENTREGA").toString());
           Timestamp stamp2 = Timestamp.valueOf(map.get("FECHA_REGISTRO").toString());

           alquiler.setId_alquiler(Integer.parseInt(map.get("ID_ALQUILER").toString()));
           alquiler.setId_juego(Integer.parseInt(map.get("ID_JUEGO").toString()));
           alquiler.setId_persona(Integer.parseInt(map.get("ID_PERSONA").toString()));
           alquiler.setFecha_entrega(new Date(stamp1.getTime()));           
           alquiler.setEntregado(map.get("ENTREGADO").toString());
           alquiler.setValor_venta(Long.parseLong(map.get("VALOR_VENTA").toString()));
           alquiler.setFecha_registro(new Date(stamp2.getTime()));
           listAlquiler.add(alquiler);
        }
        return listAlquiler;
    }

    /**
     * Web service operation
     * @param numero_documento
     * @return 
     */
    @WebMethod(operationName = "listarAlquilerPersona")
    public List<AlquilerDTO> listarAlquilerPersona(@WebParam(name = "numero_documento") String numero_documento) {
        
        PersonaDAO personaDAO =new PersonaDAO(); 
        AlquilerDAO alquilerDAO = new AlquilerDAO();
        List<AlquilerDTO> listAlquiler = new ArrayList<>();
        
        List<Map<String, ?>> persona = personaDAO.forList(numero_documento);
        List<Map<String, ?>> listaAlquiler = alquilerDAO.forList(Integer.parseInt(persona.get(0).get("ID_PERSONA").toString()));
           for(Map map : listaAlquiler){
        
           AlquilerDTO alquiler = new AlquilerDTO();
           
           Timestamp stamp1 = Timestamp.valueOf(map.get("FECHA_ENTREGA").toString());
           Timestamp stamp2 = Timestamp.valueOf(map.get("FECHA_REGISTRO").toString());

           alquiler.setId_alquiler(Integer.parseInt(map.get("ID_ALQUILER").toString()));
           alquiler.setId_juego(Integer.parseInt(map.get("ID_JUEGO").toString()));
           alquiler.setId_persona(Integer.parseInt(map.get("ID_PERSONA").toString()));
           alquiler.setFecha_entrega(new Date(stamp1.getTime()));           
           alquiler.setEntregado(map.get("ENTREGADO").toString());
           alquiler.setValor_venta(Long.parseLong(map.get("VALOR_VENTA").toString()));
           alquiler.setFecha_registro(new Date(stamp2.getTime()));
           listAlquiler.add(alquiler);
        }
        return listAlquiler;
    }
}
