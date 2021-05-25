/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRINCIPAL;

import DAO.JuegosDAO;
import DAO.PersonaDAO;
import DTO.JuegosDTO;
import DTO.PersonaDTO;
import java.util.Date;

/**
 *
 * @author rfranco
 */
public class Principal {
        public static void main(String[] args) {
            
//        PersonaDAO crud = new PersonaDAO();
//        PersonaDTO personas = new PersonaDTO();
//        personas.setNombre("rusbel");
//        personas.setTipo_documento("CC");
//        personas.setNumero_documento("12345");
//        personas.setFecha_nacimiento(new Date());
//        personas.setDireccion("calle 23");
//        personas.setCelular(32039999);
//        
//        personas.getNombre();
//        personas.getTipo_documento();
//        personas.getNumero_documento();
//        personas.getFecha_nacimiento();
//        personas.getDireccion();
//        personas.getCelular();

           JuegosDAO crud = new JuegosDAO();
           JuegosDTO juegos = new JuegosDTO();
           juegos.setTitulo("GEAR 5");
           juegos.setGenero("accion");
           juegos.setYear(new Date());
           juegos.setProtagonistas("marcus fenix");
           juegos.setDirector("microsoft");
           juegos.setProductor("coalition2");
           juegos.setTecnologia("xbox");           
           juegos.setPrecio_alquiler(45000);
           juegos.setId_juego(1);
           crud.update(juegos);
    }
}
