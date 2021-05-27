package CONEXION;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controlador.AlquilerDTO;
import controlador.ClassNotFoundException_Exception;
import controlador.JuegosDTO;
import controlador.WebServiceAlquiler;
import controlador.WebServiceAsesor;
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
public class ListarAlquiler extends HttpServlet {

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
     * @throws controlador.ClassNotFoundException_Exception
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException_Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            List<AlquilerDTO> listarAlquiler = listarAlquilerPersona(request.getParameter("id"));
            long total = 0;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarAlquiler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table  border=\"1\">");
            out.println("<tr>");
            out.println("<td>ID ALQUILER</td>"); 
            out.println("<td>TITULO</td>"); 
            out.println("<td>FECHA ENTREGA</td>"); 
            out.println("<td>VALOR VENTA</td>"); 
            out.println("</tr>");
            for(AlquilerDTO alquiler:listarAlquiler){
                List<JuegosDTO> juego = selectJuego(alquiler.getIdJuego());
            out.println("<tr>");
            out.println("<td>"+alquiler.getIdAlquiler()+"</td>"); 
            out.println("<td>"+juego.get(0).getTitulo()+"</td>"); 
            out.println("<td>"+alquiler.getFechaEntrega()+"</td>"); 
            out.println("<td>"+alquiler.getValorVenta()+"</td>"); 
            out.println("</tr>");
            total = total + alquiler.getValorVenta();
            }
                        out.println("<tr>");
                                    out.println("<td>Total</td>"); 
            out.println("<td>"+total+"</td>"); 
                                    out.println("</tr>");
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
        } catch (ClassNotFoundException_Exception ex) {
            Logger.getLogger(ListarAlquiler.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException_Exception ex) {
            Logger.getLogger(ListarAlquiler.class.getName()).log(Level.SEVERE, null, ex);
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

    private java.util.List<AlquilerDTO> listarAlquilerPersona(java.lang.String numeroDocumento) throws ClassNotFoundException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebServiceAsesor port = service.getWebServiceAsesorPort();
        return port.listarAlquilerPersona(numeroDocumento);
    }

    private java.util.List<JuegosDTO> selectJuego(int idJuego) throws ClassNotFoundException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebServiceAsesor port = service.getWebServiceAsesorPort();
        return port.selectJuego(idJuego);
    }

}
