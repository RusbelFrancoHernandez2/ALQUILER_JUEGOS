/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONEXION;

import controlador.ClassNotFoundException_Exception;
import controlador.JuegosDTO;
import controlador.ParseException_Exception;
import controlador.PersonaDTO;
import controlador.WebServiceAlquiler;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author rfranco
 */
public class CrearAlquiler extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PROGRAMA_ALQUILER/WebServiceAlquiler.wsdl")
    private WebServiceAlquiler service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws controlador.ParseException_Exception
     * @throws controlador.ClassNotFoundException_Exception
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException_Exception, ClassNotFoundException_Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            List<JuegosDTO> juego= selectJuego(Integer.parseInt(request.getParameter("id_Juego")));
            List<PersonaDTO> persona= selectPersona(request.getParameter("id"));
            String status =  crearAlquiler(persona.get(0).getIdPersonas(), juego.get(0).getIdJuego(), request.getParameter("year"),juego.get(0).getPrecioAlquiler());
                    
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearAlquiler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>FACTURA</h1>");
            out.println("<table  border=\"1\">");
            out.println("<tr>");
            out.println("<td>Nombre</td>"); 
            out.println("<td>"+persona.get(0).getNombre()+"</td>"); 
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Titulo juego</td>"); 
            out.println("<td>"+juego.get(0).getTitulo()+"</td>"); 
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Fecha Entrega</td>"); 
            out.println("<td>"+request.getParameter("year")+"</td>"); 
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Precio Alquiler</td>"); 
            out.println("<td>"+juego.get(0).getPrecioAlquiler()+"</td>"); 
            out.println("</tr>");
            out.println("</table>");
            out.println("<input type=\"button\" onclick=\" location.href = '/Asesor/page/CrearAlquiler.jsp'\" value=\"regresar\" name=\"boton\">");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException_Exception | ClassNotFoundException_Exception ex) {
            Logger.getLogger(CrearAlquiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException_Exception | ClassNotFoundException_Exception ex) {
            Logger.getLogger(CrearAlquiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private java.util.List<controlador.JuegosDTO> selectJuego(int idJuego) throws ClassNotFoundException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        controlador.WebServiceAsesor port = service.getWebServiceAsesorPort();
        return port.selectJuego(idJuego);
    }

    private java.util.List<controlador.PersonaDTO> selectPersona(java.lang.String numeroDocumento) throws ClassNotFoundException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        controlador.WebServiceAsesor port = service.getWebServiceAsesorPort();
        return port.selectPersona(numeroDocumento);
    }

    private String crearAlquiler(int idPersona, int idJuego, java.lang.String fechaEntrega, long valorVenta) throws ParseException_Exception, ClassNotFoundException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        controlador.WebServiceAsesor port = service.getWebServiceAsesorPort();
        return port.crearAlquiler(idPersona, idJuego, fechaEntrega, valorVenta);
    }

}
